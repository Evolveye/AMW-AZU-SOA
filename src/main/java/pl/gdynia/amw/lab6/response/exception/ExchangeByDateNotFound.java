package pl.gdynia.amw.lab6.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.gdynia.amw.lab6.response.ResponseException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Exchange by date not found")
public class ExchangeByDateNotFound extends ResponseException {
    public ExchangeByDateNotFound(String date) {
        super(400, date);
    }
}
