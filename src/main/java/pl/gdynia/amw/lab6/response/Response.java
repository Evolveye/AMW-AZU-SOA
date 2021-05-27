package pl.gdynia.amw.lab6.response;

public abstract class Response {
    enum Type {
        SUCCESS
    }

    private int code;
    private Type type;

    public Response(int code, Type type) {
        this.code = code;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public Type getType() {
        return type;
    }
}
