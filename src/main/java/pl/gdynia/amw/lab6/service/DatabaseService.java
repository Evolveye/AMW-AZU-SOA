package pl.gdynia.amw.lab6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gdynia.amw.lab6.model.Exchange;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseService {
    @Autowired
    private ExchangeRepository exchangeRepository;

    public void saveExchanges(List<Exchange> exchanges) {
        for (Exchange exchange : exchanges) {
            exchangeRepository.save(exchange);
        }
    }

    public void deleteAllExchanges() {
        exchangeRepository.deleteAll();
    }

    public long exchangesCount() {
        return exchangeRepository.count();
    }

    public ArrayList<Exchange> getExchanges() {
        return new ArrayList<>(exchangeRepository.findAll());
    }
}
