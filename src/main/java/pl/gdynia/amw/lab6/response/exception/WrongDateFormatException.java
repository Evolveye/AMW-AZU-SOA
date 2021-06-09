package pl.gdynia.amw.lab6.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bla bla bla")
public class WrongDateFormatException extends ResponseException {
    public WrongDateFormatException(String date) {
        super(400, "You passed wrong date format: " + date + ". It should match \"YYYY-MM-DD\"");
    }
}
