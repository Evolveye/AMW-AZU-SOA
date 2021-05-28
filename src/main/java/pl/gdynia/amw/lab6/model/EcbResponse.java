package pl.gdynia.amw.lab6.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Date;

public class EcbResponse {
    private final String subject;
    private final String sender;
    private final ArrayList<Exchange> exchanges = new ArrayList<>();

    public EcbResponse(Document apiResponse) {
        NodeList nodeList = apiResponse.getFirstChild().getChildNodes();
        String subject = null;
        String sender = null;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) continue;

            Element element = (Element) node;

            switch (element.getTagName()) {
                case "gesmes:subject":
                    subject = element.getTextContent();
                    break;

                case "gesmes:Sender":
                    sender = element.getTextContent();
                    break;

                case "Cube":
                    NodeList exchangesList = element.getChildNodes();

                    for (int j = 0; j < exchangesList.getLength(); j++) {
                        Node exchangeNode = exchangesList.item(j);

                        if (exchangeNode.getNodeType() != Node.ELEMENT_NODE) continue;

                        this.exchanges.add(new Exchange((Element) exchangeNode));
                    }

                    break;
            }
        }

        this.sender = sender;
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getSender() {
        return this.sender;
    }

    public ArrayList<Exchange> getExchanges() {
        return this.exchanges;
    }

    public Exchange getExchange(Date date) {
        for (Exchange exchange : this.exchanges) {
            if (exchange.getTime() == date) return exchange;
        }

        return null;
    }

    public Exchange getLastExchange() {
        return this.exchanges.get(0);
    }
}
