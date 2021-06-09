package pl.gdynia.amw.lab6.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.gdynia.amw.lab6.response.ResponseException;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Wrong date format")
public class WrongDateFormatException extends ResponseException {
    public WrongDateFormatException(String date) {
        super(402, date);
    }
}
