package za.co.tangentsolutions.exceptionHandlers;

public class UserIdMismatchException extends RuntimeException {

    public UserIdMismatchException() {
        super();
    }

    public UserIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}