
package pl.gdynia.amw.lab6.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.gdynia.amw.lab6.response.ResponseException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Exchange not found")
public class ExchangeNotFoundException extends ResponseException {
    public ExchangeNotFoundException() {
        super(403);
    }
}
