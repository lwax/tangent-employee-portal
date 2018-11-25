package za.co.tangentsolutions.exceptionHandlers;

public class PositionNotFoundException extends RuntimeException {

    public PositionNotFoundException() {
        super();
    }

    public PositionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}