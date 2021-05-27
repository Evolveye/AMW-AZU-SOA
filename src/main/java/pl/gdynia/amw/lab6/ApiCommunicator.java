package pl.gdynia.amw.lab6;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import pl.gdynia.amw.lab6.bankApiElements.ApiResponse;
import pl.gdynia.amw.lab6.bankApiElements.Exchange;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ApiCommunicator {
    private static final String API_URI = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-hist.xml?bcd0938de3675ce9631d23856979fd68";
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;

    public ApiCommunicator() throws ParserConfigurationException, IOException, SAXException {
        this.factory = DocumentBuilderFactory.newInstance();
        this.builder = factory.newDocumentBuilder();

        ApiResponse apiResponse = new ApiResponse(this.fetchApi());

//        for (Exchange exchange : apiResponse.getExchanges()) {
//            System.out.println("Last date: " + exchange.getTime() + " | Rate PL: " + exchange.getRateByCurrency("PLN").getRate());
//        }
    }

    public Document fetchApi() throws IOException, SAXException {
        return builder.parse(API_URI);
    }
}
