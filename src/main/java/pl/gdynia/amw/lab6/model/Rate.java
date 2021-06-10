package pl.gdynia.amw.lab6.model;

import org.w3c.dom.Element;

import java.math.BigDecimal;

public class Rate {
    private String currency;
    private BigDecimal rate;

    public Rate(Element rateElement) {
        this.currency = rateElement.getAttribute("currency");
        this.rate = new BigDecimal(rateElement.getAttribute("rate"));
    }
    public Rate(String currency, BigDecimal rate) {
        this.currency = currency;
        this.rate = rate;
    }
    public Rate() {}

    public Rate(String currency, double rate) {
        this(currency,new BigDecimal(rate));
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getCurrency() {
        return this.currency;
    }

    public void setRate(BigDecimal rate) {
         this.rate = rate;
    }
    public BigDecimal getRate() {
        return this.rate;
    }
}
