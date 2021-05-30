package pl.gdynia.amw.lab6.service;

import org.springframework.stereotype.Service;
import pl.gdynia.amw.lab6.ExchangeCalculator;
import pl.gdynia.amw.lab6.Suppress;
import pl.gdynia.amw.lab6.model.EcbResponse;

@Service
public class MainService {
    public final EcbCommunicatorService apiCommunicator;
    public final ExchangeCalculator calculator;

    public MainService() {
    	this.calculator = new ExchangeCalculator();
    	this.apiCommunicator = new EcbCommunicatorService();
    }

    @Suppress
    public EcbResponse getLastApiResponse() {
    	return this.apiCommunicator.getLastApiResponse();
	}
}
