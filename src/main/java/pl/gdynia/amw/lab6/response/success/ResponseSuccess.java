package pl.gdynia.amw.lab6.response.success;

public abstract class ResponseSuccess {
    private Object data;
    private int code;

    public ResponseSuccess(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public int getCode() {
        return code;
    }
}
