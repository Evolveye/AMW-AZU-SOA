package pl.gdynia.amw.lab6.bankApiElements;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Rate {
    private String currency;
    private float rate;

    public Rate(Element rateElement) {
        this.currency = rateElement.getAttribute("currency");
        this.rate = Float.parseFloat(rateElement.getAttribute("rate"));
    }

    public String getCurrency() {
        return this.currency;
    }

    public float getRate() {
        return this.rate;
    }
}
