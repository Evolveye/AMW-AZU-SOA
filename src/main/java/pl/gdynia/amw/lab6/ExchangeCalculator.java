package pl.gdynia.amw.lab6;

import pl.gdynia.amw.lab6.apiElement.Rate;

public class ExchangeCalculator {
    public float calculateExchange(Rate rateFrom, Rate rateTo) {
        return rateTo.getRate() / rateFrom.getRate();
    }

    public float calculateExchange(Rate rate) {
        return rate.getRate();
    }
}
