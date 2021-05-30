package pl.gdynia.amw.lab6.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import pl.gdynia.amw.lab6.model.EcbResponse;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;

@Service
public class EcbCommunicatorService {
    // application.properties
    private static final String API_URI = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-hist.xml?bcd0938de3675ce9631d23856979fd68";
    private static final int DELAY_IN_HOURS = 1;
    private final DocumentBuilder builder;
    private EcbResponse lastApiResponse;

    public EcbCommunicatorService() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;

        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println("\nParserConfigurationException\n");
        }

        this.builder = builder;
        System.out.println("EcbCommunicatorService constructor");
    }

    @Scheduled(fixedDelay = 1000 * 60 * 60 * DELAY_IN_HOURS)
    public void interval() {
        this.lastApiResponse = new EcbResponse(this.fetchApi());
    }

    public Document fetchApi() {
        System.out.println("ECB fetching");

        try {
            return builder.parse(API_URI);
        } catch (MalformedURLException e) {
            System.out.println("\nMalformedURLException\n");
        } catch (IOException e) {
            System.out.println("\nIOException\n");
        } catch (SAXException e) {
            System.out.println("\nSAXException\n");
        }

        return null;
    }

    public EcbResponse getLastApiResponse() {
        return this.lastApiResponse;
    }
}
