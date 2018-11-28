package za.co.tangentsolutions.employeeportal.exceptions;

public class EmployeeIdMismatchException extends RuntimeException {

    public EmployeeIdMismatchException() {
        super();
    }

    public EmployeeIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}