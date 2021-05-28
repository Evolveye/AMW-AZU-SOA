package pl.gdynia.amw.lab6.response.exception;

import pl.gdynia.amw.lab6.Suppress;

public abstract class ResponseException extends RuntimeException {
    public static class Response {
        private final int code;
        private final String message;

        public Response(int code, String message) {
            this.code = code;
            this.message = message;
        }

        @Suppress
        public int getCode() {
            return code;
        }

        @Suppress
        public String getMessage() {
            return message;
        }
    }

    private final Response response;

    public ResponseException(int code, String message) {
        this.response = new Response(code,message);
    }

    public Response getResponse() {
        return response;
    }
}
