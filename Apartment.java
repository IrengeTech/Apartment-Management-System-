// Apartment.java
public class Apartment {
    private String streetAddress;
    private String apartmentNumber;
    private int bedrooms;
    private double rent;

    // Constructor with validation
    public Apartment(String streetAddress, String apartmentNumber, int bedrooms, double rent) throws ApartmentException {
        if (!apartmentNumber.matches("\\d{3}")) {
            throw new ApartmentException("Apartment number must be exactly three digits.");
        }
        if (bedrooms < 1 || bedrooms > 4) {
            throw new ApartmentException("Number of bedrooms must be between 1 and 4.");
        }
        if (rent < 500 || rent > 2500) {
            throw new ApartmentException("Rent must be between $500 and $2500.");
        }

        this.streetAddress = streetAddress;
        this.apartmentNumber = apartmentNumber;
        this.bedrooms = bedrooms;
        this.rent = rent;
    }

    // Getters
    public String getStreetAddress() { return streetAddress; }
    public String getApartmentNumber() { return apartmentNumber; }
    public int getBedrooms() { return bedrooms; }
    public double getRent() { return rent; }

    // Setters
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public void setApartmentNumber(String apartmentNumber) throws ApartmentException {
        if (!apartmentNumber.matches("\\d{3}")) {
            throw new ApartmentException("Apartment number must be exactly three digits.");
        }
        this.apartmentNumber = apartmentNumber;
    }
    public void setBedrooms(int bedrooms) throws ApartmentException {
        if (bedrooms < 1 || bedrooms > 4) {
            throw new ApartmentException("Number of bedrooms must be between 1 and 4.");
        }
        this.bedrooms = bedrooms;
    }
    public void setRent(double rent) throws ApartmentException {
        if (rent < 500 || rent > 2500) {
            throw new ApartmentException("Rent must be between $500 and $2500.");
        }
        this.rent = rent;
    }

    // toString method
    @Override
    public String toString() {
        return "Apartment{" +
                "Street Address='" + streetAddress + '\'' +
                ", Apartment Number='" + apartmentNumber + '\'' +
                ", Bedrooms=" + bedrooms +
                ", Rent=$" + rent +
                '}';
    }
}