public class Apartment {
    private String streetAddress;
    private String apartmentNumber;
    private int bedrooms;
    private double rent;

    public Apartment(String streetAddress,
                     String apartmentNumber,
                     int bedrooms,
                     double rent) throws ApartmentException {

        if (!apartmentNumber.matches("\\d{3}")) {
            throw new ApartmentException(
                    "Invalid apartment number. Apartment object will not be created!");
        }

        if (bedrooms < 1 || bedrooms > 4) {
            throw new ApartmentException(
                    "Invalid number of beds. Apartment object will not be created!");
        }

        if (rent < 500 || rent > 2500) {
            throw new ApartmentException(
                    "Invalid rent amount. Apartment object will not be created!");
        }

        this.streetAddress = streetAddress;
        this.apartmentNumber = apartmentNumber;
        this.bedrooms = bedrooms;
        this.rent = rent;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public double getRent() {
        return rent;
    }

    @Override
    public String toString() {
        return "Apartment object successfully created\n" +
                "Street Name: " + streetAddress + "\n" +
                "Apartment Number: " + apartmentNumber + "\n" +
                "Number of beds: " + bedrooms + "\n" +
                "Rent: " + rent + "\n";
    }
}