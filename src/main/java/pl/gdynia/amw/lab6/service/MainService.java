package pl.gdynia.amw.lab6.service;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import pl.gdynia.amw.lab6.ApiCommunicator;
import pl.gdynia.amw.lab6.ExchangeCalculator;
import pl.gdynia.amw.lab6.Suppress;
import pl.gdynia.amw.lab6.model.EcbResponse;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;

@Service
public class MainService {
    public ApiCommunicator apiCommunicator;
    public ExchangeCalculator calculator;

    public MainService() {
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

    @Suppress
    public EcbResponse getLastApiResponse() {
    	return this.apiCommunicator.getLastApiResponse();
	}
}
