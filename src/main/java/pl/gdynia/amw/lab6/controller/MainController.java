package pl.gdynia.amw.lab6.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.gdynia.amw.lab6.model.Exchange;
import pl.gdynia.amw.lab6.model.Rate;
import pl.gdynia.amw.lab6.response.exception.ExchangeByDateNotFound;
import pl.gdynia.amw.lab6.response.exception.ExchangeNotFoundException;
import pl.gdynia.amw.lab6.response.exception.WrongCurrencyException;
import pl.gdynia.amw.lab6.response.exception.WrongDateFormatException;
import pl.gdynia.amw.lab6.response.success.ExchangeRateCalcSuccess;
import pl.gdynia.amw.lab6.service.EcbCommunicatorService;
import pl.gdynia.amw.lab6.service.ExchangeCalculatorService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@RestController
public class MainController {
    private final Pattern datePattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private final Logger logger = LoggerFactory.getLogger("MainControllerLogger");

    @Autowired
    private ExchangeCalculatorService calculator;

    @Autowired
    private EcbCommunicatorService ecbCommunicator;

    @GetMapping("/exchange/rate/{currencyTo}")
    public ExchangeRateCalcSuccess exchangeRateEurToX(@PathVariable String currencyTo, @RequestParam(name = "date", required = false) String date) {
        return exchangeRate("EUR", currencyTo, date);
    }

    @GetMapping("/exchange/rate/{currencyFrom}/{currencyTo}")
    public ExchangeRateCalcSuccess exchangeRateXToY(@PathVariable String currencyFrom, @PathVariable String currencyTo, @RequestParam(name = "date", required = false) String date) {
        return exchangeRate(currencyFrom, currencyTo, date);
    }

    private ExchangeRateCalcSuccess exchangeRate(String currencyFrom, String currencyTo, String date) {
        String currencyFromUpper = currencyFrom.toUpperCase();
        String currencyToUpper = currencyTo.toUpperCase();

        Date parsedDate;
        Exchange exchange;

        logger.info(String.format("GET /exchange/rate/:currencyFrom/:currencyTo?date { currencyFrom=%s, currencyTo=%s, date=%s }",currencyFromUpper,currencyToUpper,date));

        if (date == null) {
            exchange = ecbCommunicator.getLastApiResponse().getLastExchange();
        } else {
            if (!datePattern.matcher(date).matches()) throw new WrongDateFormatException(date);

            try {
                parsedDate = simpleDateFormat.parse(date);
                exchange = ecbCommunicator.getLastApiResponse().getExchange(parsedDate);

                if (exchange == null) throw new ExchangeByDateNotFound(date);
            } catch (ParseException e) {
                throw new WrongDateFormatException(date);
            }
        }

        if (exchange == null) throw new ExchangeNotFoundException();

        Rate rateFromObj = exchange.getRateByCurrency(currencyFromUpper);
        Rate rateToObj = exchange.getRateByCurrency(currencyToUpper);

        if (rateFromObj == null) throw new WrongCurrencyException(currencyFromUpper);
        if (rateToObj == null) throw new WrongCurrencyException(currencyToUpper);

        BigDecimal rate = calculator.calculateExchange(rateFromObj, rateToObj);

        return ExchangeRateCalcSuccess.newSuccess(currencyFromUpper, currencyToUpper, rate, exchange.getTime());
    }
}
