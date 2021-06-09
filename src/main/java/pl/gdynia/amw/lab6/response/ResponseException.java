package pl.gdynia.amw.lab6.response;

import pl.gdynia.amw.lab6.Suppress;

public abstract class ResponseException extends RuntimeException {
    private final Object[] parameters;
    private final int code;

    public ResponseException(int code, Object... parameters) {
        this.code = code;
        this.parameters = parameters;
    }

    @Suppress
    public Object[] getParameters() {
        return parameters;
    }

    @Suppress
    public int getCode() {
        return code;
    }
}
