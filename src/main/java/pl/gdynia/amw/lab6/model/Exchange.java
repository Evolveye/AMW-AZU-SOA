package pl.gdynia.amw.lab6.model;

import org.springframework.data.annotation.Id;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Exchange {
    @Id
    public String id;
    private Date time;
    private ArrayList<Rate> rates;

    public Exchange(Element exchangeElement) {
        Date time = null;

        rates = new ArrayList<>();

        try {
            time = new SimpleDateFormat("yyyy-MM-dd").parse(exchangeElement.getAttribute("time"));
        } catch (ParseException e) {
            System.out.println("Date parse error");
        }

        this.time = time;

        NodeList rates = exchangeElement.getChildNodes();

        for (int i = 0; i < rates.getLength(); i++) {
            Node node = rates.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) this.rates.add(new Rate((Element) node));
        }
    }
    public Exchange() {}

    public String getId() {
        return this.id;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    public Date getTime() {
        return time;
    }

    public void setRates(List<Rate> rates) {
        this.rates = new ArrayList<>(rates);
    }
    public ArrayList<Rate> getRates() {
        return rates;
    }

    public Rate getRateByCurrency(String currency) {
        if (currency.equals("EUR")) return new Rate("EUR", 1);

        for (Rate rate : this.rates) {
            if (rate.getCurrency().equals(currency)) return rate;
        }

        return null;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "time=" + time +
                ", rates=" + rates.size() +
                '}';
    }
}
