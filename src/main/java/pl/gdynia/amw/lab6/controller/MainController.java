package pl.gdynia.amw.lab6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.gdynia.amw.lab6.model.Exchange;
import pl.gdynia.amw.lab6.model.Rate;
import pl.gdynia.amw.lab6.response.exception.WrongCurrencyException;
import pl.gdynia.amw.lab6.response.success.ExchangeRateCalcSuccess;
import pl.gdynia.amw.lab6.service.EcbCommunicatorService;
import pl.gdynia.amw.lab6.service.ExchangeCalculatorService;
import pl.gdynia.amw.lab6.service.ExchangeRepository;

import java.math.BigDecimal;

@RestController
public class MainController {
    @Autowired
    ExchangeRepository exchangeRepository;

    @Autowired
    ExchangeCalculatorService calculator;

    @Autowired
    EcbCommunicatorService ecbCommunicator;

    @GetMapping("/exchange/rate/{currencyTo}")
    ExchangeRateCalcSuccess exchangeRate(@PathVariable String currencyTo) {
        String currencyFromUpper = currencyTo.toUpperCase();

        System.out.println(exchangeRepository.count());

        Exchange exchange = ecbCommunicator.getLastApiResponse().getLastExchange();
        Rate rateObj = exchange.getRateByCurrency(currencyFromUpper);

        if (rateObj == null) {
            throw new WrongCurrencyException(currencyFromUpper);
        }

        BigDecimal rate = calculator.calculateExchange(rateObj);

        return ExchangeRateCalcSuccess.newSuccess("EUR",currencyFromUpper, rate);
    }

    @GetMapping("/exchange/rate/{currencyFrom}/{currencyTo}")
    ExchangeRateCalcSuccess exchangeRate(@PathVariable String currencyFrom, @PathVariable String currencyTo) {
        String currencyFromUpper = currencyFrom.toUpperCase();
        String currencyToUpper = currencyTo.toUpperCase();

        Exchange exchange = ecbCommunicator.getLastApiResponse().getLastExchange();
        Rate rateFromObj = exchange.getRateByCurrency(currencyFromUpper);
        Rate rateToObj = exchange.getRateByCurrency(currencyToUpper);

        if (rateFromObj == null) {
            throw new WrongCurrencyException(currencyFromUpper);
        }

        if (rateToObj == null) {
            throw new WrongCurrencyException(currencyToUpper);
        }

        BigDecimal rate = calculator.calculateExchange(rateFromObj, rateToObj);

        return ExchangeRateCalcSuccess.newSuccess(currencyFromUpper, currencyToUpper, rate);
    }
}
