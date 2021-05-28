package pl.gdynia.amw.lab6.model;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Exchange {
    private Date time;
    private ArrayList<Rate> rates = new ArrayList<>();

    public Exchange(Element exchangeElement) {
        try {
            this.time = new SimpleDateFormat("yyyy-MM-dd").parse(exchangeElement.getAttribute("time"));
        } catch (ParseException e) {
            System.out.println("Date parse error");
        }

        NodeList rates = exchangeElement.getChildNodes();

        for (int i = 0; i < rates.getLength(); i++) {
            Node node = rates.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) this.rates.add(new Rate((Element) node));
        }
    }

    public Date getTime() {
        return this.time;
    }

    public ArrayList<Rate> getRates() {
        return this.rates;
    }

    public Rate getRateByCurrency(String currency) {
        if (currency.equals("EUR")) return new Rate("EUR", 1);

        for (Rate rate : this.rates) {
            if (rate.getCurrency().equals(currency)) return rate;
        }

        return null;
    }
}
