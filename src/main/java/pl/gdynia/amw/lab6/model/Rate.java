package pl.gdynia.amw.lab6.model;

import org.w3c.dom.Element;

import java.math.BigDecimal;

public class Rate {
    private final String currency;
    private final BigDecimal rate;

    public Rate(Element rateElement) {
        this.currency = rateElement.getAttribute("currency");
        this.rate = new BigDecimal(rateElement.getAttribute("rate"));
    }
    public Rate(String currency, BigDecimal rate) {
        this.currency = currency;
        this.rate = rate;
    }
    public Rate(String currency, double rate) {
        this(currency,new BigDecimal(rate));
    }

    public String getCurrency() {
        return this.currency;
    }

    public BigDecimal getRate() {
        return this.rate;
    }
}
