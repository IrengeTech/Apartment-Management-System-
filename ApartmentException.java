// ApartmentException.java
public class ApartmentException extends Exception {

    // Default constructor with default message
    public ApartmentException() {
        super("Apartment data is invalid.");
    }

    // Constructor that accepts a custom message
    public ApartmentException(String message) {
        super(message);
    }
}