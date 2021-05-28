package pl.gdynia.amw.lab6;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import pl.gdynia.amw.lab6.model.EcbResponse;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ApiCommunicator {
    // application.properties
    private static final String API_URI = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-hist.xml?bcd0938de3675ce9631d23856979fd68";
    private final DocumentBuilder builder;

    private final EcbResponse lastApiResponse;

    public ApiCommunicator() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        this.builder = factory.newDocumentBuilder();

        this.lastApiResponse = new EcbResponse(this.fetchApi());
    }

    public Document fetchApi() throws IOException, SAXException {
        return builder.parse(API_URI);
    }

    public EcbResponse getLastApiResponse() {
        return this.lastApiResponse;
    }
}
