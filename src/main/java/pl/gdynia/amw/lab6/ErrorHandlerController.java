package pl.gdynia.amw.lab6;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.gdynia.amw.lab6.response.exception.ResponseException;

@RestControllerAdvice
public class ErrorHandlerController {
    @ExceptionHandler(ResponseException.class)
    public ResponseException.Response handleException(ResponseException e) {
        return e.getResponse();
    }
}
