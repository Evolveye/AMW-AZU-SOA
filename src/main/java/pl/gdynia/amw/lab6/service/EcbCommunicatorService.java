package pl.gdynia.amw.lab6.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import pl.gdynia.amw.lab6.model.EcbResponse;

import javax.annotation.PostConstruct;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;

@Service
public class EcbCommunicatorService {
    @Autowired
    DatabaseService databaseService;

    @Value("${app.ecbApiUri:test}")
    private String API_URI;

    private DocumentBuilder builder;
    private EcbResponse lastApiResponse;

    private Logger logger = LoggerFactory.getLogger("EcbCommunicatorServiceLogger");

    @PostConstruct
    public void init() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;

        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println("\nParserConfigurationException\n");
        }

        this.builder = builder;

        interval();
    }

    @Scheduled(cron = "${app.intervalCronDelay}")
    public void interval() {
        logger.info("API fetching...");
        this.lastApiResponse = new EcbResponse(this.fetchApi());
        logger.info("API fetching done");

        databaseService.deleteAllExchanges();
        databaseService.saveExchanges(this.lastApiResponse.getExchanges());
    }

    public Document fetchApi() {
        try {
            return builder.parse(API_URI);
        } catch (MalformedURLException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (SAXException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    public EcbResponse getLastApiResponse() {
        return this.lastApiResponse;
    }
}
