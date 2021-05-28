package pl.gdynia.amw.lab6;

import pl.gdynia.amw.lab6.model.Rate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeCalculator {
    public BigDecimal calculateExchange(Rate rateFrom, Rate rateTo) {
        return rateTo.getRate().divide( rateFrom.getRate(), RoundingMode.UP);
    }

    public BigDecimal calculateExchange(Rate rate) {
        return rate.getRate();
    }
}
