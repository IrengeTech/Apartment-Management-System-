// ApartmentDemo.java
import java.util.ArrayList;
import java.util.Scanner;

public class ApartmentDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Apartment> apartments = new ArrayList<>();
        String response;

        do {
            System.out.print("\nEnter Street Name: ");
            String streetAddress = scanner.nextLine().trim();

            // Apartment Number
            System.out.print("Enter the apartment number: ");
            String apartmentNumber = scanner.nextLine().trim();

            if (!apartmentNumber.matches("\\d{3}")) {
                System.out.println("Invalid apartment number. Apartment object will not be created!");
                System.out.print("Enter 'y' or 'yes' to continue, anything else to stop: ");
                response = scanner.nextLine().trim().toLowerCase();
                continue;
            } else {
                System.out.println(apartmentNumber + " is valid");
            }

            // Bedrooms
            System.out.print("Enter the number of beds: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid number of beds. Apartment object will not be created!");
                scanner.next(); // clear invalid input
                scanner.nextLine(); // clear newline
                System.out.print("Enter 'y' or 'yes' to continue, anything else to stop: ");
                response = scanner.nextLine().trim().toLowerCase();
                continue;
            }

            int bedrooms = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (bedrooms < 1 || bedrooms > 4) {
                System.out.println("Invalid number of beds. Apartment object will not be created!");
                System.out.print("Enter 'y' or 'yes' to continue, anything else to stop: ");
                response = scanner.nextLine().trim().toLowerCase();
                continue;
            } else {
                System.out.println(bedrooms + " is valid");
            }

            // Rent
            System.out.print("Enter the rent amount: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid rent amount. Apartment object will not be created!");
                scanner.next(); // clear invalid input
                scanner.nextLine();
                System.out.print("Enter 'y' or 'yes' to continue, anything else to stop: ");
                response = scanner.nextLine().trim().toLowerCase();
                continue;
            }

            double rent = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            if (rent < 500 || rent > 2500) {
                System.out.println("Invalid rent amount. Apartment object will not be created!");
                System.out.print("Enter 'y' or 'yes' to continue, anything else to stop: ");
                response = scanner.nextLine().trim().toLowerCase();
                continue;
            } else {
                System.out.println(rent + " is valid");
            }

            // Create valid apartment
            try {
                Apartment apartment = new Apartment(streetAddress, apartmentNumber, bedrooms, rent);
                apartments.add(apartment);
            } catch (ApartmentException e) {
                System.out.println("Failed to create apartment: " + e.getMessage());
            }

            // Ask to continue after successful entry
            System.out.print("Enter 'y' or 'yes' to continue, anything else to stop: ");
            response = scanner.nextLine().trim().toLowerCase();

        } while (response.equals("y") || response.equals("yes"));

        // Final Output
        for (Apartment apt : apartments) {
            System.out.println("Apartment object successfully created");
            System.out.println("Street Name: " + apt.getStreetAddress());
            System.out.println("Apartment Number: " + apt.getApartmentNumber());
            System.out.println("Number of beds: " + apt.getBedrooms());
            System.out.println("Rent: " + apt.getRent());
        }

        
    }
}