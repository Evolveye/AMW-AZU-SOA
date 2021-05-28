package pl.gdynia.amw.lab6.response.exception;

public abstract class ResponseException extends RuntimeException {
    public static class Response {
        private int code;
        private String message;

        public Response(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    private Response response;

    public ResponseException(int code, String message) {
        this.response = new Response(code,message);
    }

    public Response getResponse() {
        return response;
    }
}
