import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ApartmentGUI extends Application {

    private final ArrayList<Apartment> apartments = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        Label streetLabel = new Label("Street Name:");
        TextField streetField = new TextField();

        Label apartmentLabel = new Label("Apartment Number:");
        TextField apartmentField = new TextField();

        Label bedsLabel = new Label("Number of Beds:");
        TextField bedsField = new TextField();

        Label rentLabel = new Label("Rent Amount:");
        TextField rentField = new TextField();

        Button addButton = new Button("Add Apartment");
        Button displayButton = new Button("Display Apartments");
        Button clearButton = new Button("Clear Fields");

        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(300);

        addButton.setOnAction(e -> {
            String street = streetField.getText().trim();
            String apartmentNumber = apartmentField.getText().trim();

            // Validate Apartment Number
            if (!apartmentNumber.matches("\\d{3}")) {
                showAlert("Invalid apartment number. Apartment object will not be created!");
                return;
            }

            int beds;
            try {
                beds = Integer.parseInt(bedsField.getText().trim());
            } catch (NumberFormatException ex) {
                showAlert("Invalid number of beds. Apartment object will not be created!");
                return;
            }

            if (beds < 1 || beds > 4) {
                showAlert("Invalid number of beds. Apartment object will not be created!");
                return;
            }

            double rent;
            try {
                rent = Double.parseDouble(rentField.getText().trim());
            } catch (NumberFormatException ex) {
                showAlert("Invalid rent amount. Apartment object will not be created!");
                return;
            }

            if (rent < 500 || rent > 2500) {
                showAlert("Invalid rent amount. Apartment object will not be created!");
                return;
            }

            try {
                Apartment apartment = new Apartment(street,
                        apartmentNumber,
                        beds,
                        rent);

                apartments.add(apartment);

                showAlert("Apartment object successfully created!");

                streetField.clear();
                apartmentField.clear();
                bedsField.clear();
                rentField.clear();

            } catch (ApartmentException ex) {
                showAlert(ex.getMessage());
            }
        });

        displayButton.setOnAction(e -> {
            outputArea.clear();

            if (apartments.isEmpty()) {
                outputArea.setText("No apartments stored.");
                return;
            }

            for (Apartment apartment : apartments) {
                outputArea.appendText(apartment.toString() + "\n");
            }
        });

        clearButton.setOnAction(e -> {
            streetField.clear();
            apartmentField.clear();
            bedsField.clear();
            rentField.clear();
            outputArea.clear();
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        root.getChildren().addAll(
                streetLabel,
                streetField,
                apartmentLabel,
                apartmentField,
                bedsLabel,
                bedsField,
                rentLabel,
                rentField,
                new HBox(10, addButton, displayButton, clearButton),
                outputArea
        );

        Scene scene = new Scene(root, 500, 550);

        primaryStage.setTitle("Apartment Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Apartment System");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}