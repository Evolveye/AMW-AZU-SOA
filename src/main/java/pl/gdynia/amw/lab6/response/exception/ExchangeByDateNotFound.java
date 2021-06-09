package pl.gdynia.amw.lab6.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bla bla bla")
public class ExchangeByDateNotFound extends ResponseException {
    public ExchangeByDateNotFound(String date) {
        super(400, "Exchange by provided date (" + date + ") not found.");
    }
}
