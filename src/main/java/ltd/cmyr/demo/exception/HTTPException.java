package ltd.cmyr.demo.exception;

public class HTTPException extends Exception {

    public int statusCode;

    public HTTPException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public HTTPException() {
        super();
    }

    public HTTPException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public HTTPException(String message, Throwable cause) {
        super(message, cause);

    }

    public HTTPException(String message) {
        super(message);

    }

    public HTTPException(Throwable cause) {
        super(cause);

    }
}
