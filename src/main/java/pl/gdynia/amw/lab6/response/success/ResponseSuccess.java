package pl.gdynia.amw.lab6.response.success;

import pl.gdynia.amw.lab6.Suppress;

public abstract class ResponseSuccess {
    private final Object data;
    private final int code;

    public ResponseSuccess(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    @Suppress
    public Object getData() {
        return data;
    }

    @Suppress
    public int getCode() {
        return code;
    }
}
