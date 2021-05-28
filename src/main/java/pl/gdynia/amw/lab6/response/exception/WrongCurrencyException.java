package pl.gdynia.amw.lab6.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Bla bla bla")
public class WrongCurrencyException extends ResponseException {
    public WrongCurrencyException(String wrongCurrency) {
        super(400, "We don't have data about currency \"" + wrongCurrency + "\"");
    }
}
