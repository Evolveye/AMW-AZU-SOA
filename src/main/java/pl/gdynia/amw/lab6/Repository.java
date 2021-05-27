package pl.gdynia.amw.lab6;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import pl.gdynia.amw.lab6.bankApiElements.ApiResponse;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;

@Service
public class Repository {
    public ApiCommunicator apiCommunicator;
    public ExchangeCalculator calculator;

    public Repository() {
    	this.calculator = new ExchangeCalculator();

		try {
            this.apiCommunicator = new ApiCommunicator();
		} catch (MalformedURLException e) {
			System.out.println("\nMalformedURLException\n");
		} catch (IOException e) {
			System.out.println("\nIOException\n");
		} catch (ParserConfigurationException e) {
			System.out.println("\nParserConfigurationException\n");
		} catch (SAXException e) {
			System.out.println("\nSAXException\n");
		}
    }

    public ApiResponse getLastApiResponse() {
    	return this.apiCommunicator.getLastApiResponse();
	}
}
