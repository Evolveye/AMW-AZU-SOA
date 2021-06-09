package pl.gdynia.amw.lab6.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.gdynia.amw.lab6.Suppress;
import pl.gdynia.amw.lab6.response.ResponseException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@ConfigurationProperties(prefix = "app")
public class ErrorHandlerController {
    private Map<Integer,String> codeMessageMap;

    @ExceptionHandler(ResponseException.class)
    public Map<String,Object> handleException(ResponseException e) {
        Map<String,Object> map = new HashMap<>();

        map.put("code",e.getCode());

        String message = this.codeMessageMap.get(e.getCode());

        if (message == null) return map;

        String formatedMessage = e.getParameters() == null ? message : String.format(message,e.getParameters());

        map.put("message", formatedMessage);

        return map;
    }

    @Suppress
    public void setCodeMessageMap(Map<Integer, String> codeMessageMap) {
        this.codeMessageMap = codeMessageMap;
    }
}
