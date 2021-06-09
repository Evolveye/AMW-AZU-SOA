package pl.gdynia.amw.lab6.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.gdynia.amw.lab6.response.ResponseException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Wrong currency")
public class WrongCurrencyException extends ResponseException {
    public WrongCurrencyException(String date) {
        super(401, date);
    }
}
