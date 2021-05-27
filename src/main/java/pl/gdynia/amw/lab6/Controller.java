package pl.gdynia.amw.lab6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gdynia.amw.lab6.bankApiElements.Exchange;
import pl.gdynia.amw.lab6.response.ExchangeSuccess;

@RestController
public class Controller {
    @Autowired
    Repository repo;

    @GetMapping("/week")
    ExchangeSuccess getLastWeek() {
        Exchange exchange = repo.apiCommunicator.getLastApiResponse().getLastExchange();
        float rate = repo.calculator.calculateExchange(exchange.getRateByCurrency("PLN"));

        return new ExchangeSuccess("X", "X", rate);
    }
}
