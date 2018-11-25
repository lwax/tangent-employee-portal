package za.co.tangentsolutions.exceptionHandlers;

public class PositionIdMismatchException extends RuntimeException {

    public PositionIdMismatchException() {
        super();
    }

    public PositionIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}