public class ApartmentException extends Exception {

    // Default constructor
    public ApartmentException() {
        super("Apartment data is invalid.");
    }

    // Constructor with custom message
    public ApartmentException(String message) {
        super(message);
    }
}