package pl.gdynia.amw.lab6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.gdynia.amw.lab6.apiElement.Exchange;
import pl.gdynia.amw.lab6.apiElement.Rate;
import pl.gdynia.amw.lab6.response.exception.WrongCurrencyException;
import pl.gdynia.amw.lab6.response.success.ExchangeRateCalcSuccess;

@RestController
public class Controller {
    @Autowired
    Repository repo;

    @GetMapping("/exchange/rate/{currencyTo}")
    ExchangeRateCalcSuccess exchangeRate(@PathVariable String currencyTo) {
        String currencyFromUpper = currencyTo.toUpperCase();

        Exchange exchange = repo.apiCommunicator.getLastApiResponse().getLastExchange();
        Rate rateObj = exchange.getRateByCurrency(currencyFromUpper);

        if (rateObj == null) {
            throw new WrongCurrencyException(currencyFromUpper);
        }

        float rate = repo.calculator.calculateExchange(rateObj);

        return ExchangeRateCalcSuccess.newSuccess("EUR",currencyFromUpper, rate);
    }

    @GetMapping("/exchange/rate/{currencyFrom}/{currencyTo}")
    ExchangeRateCalcSuccess exchangeRate(@PathVariable String currencyFrom, @PathVariable String currencyTo) {
        String currencyFromUpper = currencyFrom.toUpperCase();
        String currencyToUpper = currencyTo.toUpperCase();

        Exchange exchange = repo.apiCommunicator.getLastApiResponse().getLastExchange();
        Rate rateFromObj = exchange.getRateByCurrency(currencyFromUpper);
        Rate rateToObj = exchange.getRateByCurrency(currencyToUpper);

        if (rateFromObj == null) {
            throw new WrongCurrencyException(currencyFromUpper);
        }

        if (rateToObj == null) {
            throw new WrongCurrencyException(currencyFromUpper);
        }

        float rate = repo.calculator.calculateExchange(rateFromObj, rateToObj);

        return ExchangeRateCalcSuccess.newSuccess(currencyFromUpper, currencyToUpper, rate);
    }
}
