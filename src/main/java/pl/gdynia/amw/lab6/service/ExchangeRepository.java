package pl.gdynia.amw.lab6.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.gdynia.amw.lab6.model.Exchange;

public interface ExchangeRepository extends MongoRepository<Exchange,String> {}
