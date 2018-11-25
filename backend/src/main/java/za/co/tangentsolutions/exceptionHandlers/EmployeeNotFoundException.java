package za.co.tangentsolutions.exceptionHandlers;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {
        super();
    }

    public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}