Apartment Management System (JavaFX)

Overview

The Apartment Management System is a JavaFX desktop application that allows users to enter, validate, store, and display apartment information. The program uses object-oriented programming principles and custom exception handling to ensure that apartment data is valid before objects are created.

The application validates:

Apartment numbers (must contain exactly 3 digits)
Number of beds (must be between 1 and 4)
Rent amount (must be between $500 and $2500)

Only valid apartment records are stored and displayed.

Technologies
Java
JavaFX
Object-Oriented Programming (OOP)
Exception Handling
Features
GUI-based apartment entry form
Input validation with custom exception handling
Store multiple apartment records
Display all valid apartments
Clear form functionality
User-friendly popup alerts
Object-oriented design

Screenshots
Main Application Window
<img width="1366" height="768" alt="Screenshot (948)" src="https://github.com/user-attachments/assets/6b2ea74f-a11b-424d-939f-b924e5b6e2c4" />

Add screenshot here
<img width="1366" height="768" alt="Screenshot (953)" src="https://github.com/user-attachments/assets/940e211a-691b-466f-a3e3-982cfd2e0608" />

Apartment Successfully Added

Add screenshot here
<img width="1366" height="768" alt="Screenshot (950)" src="https://github.com/user-attachments/assets/a651aa8e-e39b-4d82-8fd4-5bfee075b2e0" />

Validation Error Message

Add screenshot here

<img width="1366" height="768" alt="Screenshot (954)" src="https://github.com/user-attachments/assets/af42c782-ad4b-4382-bc48-a61028f9eb30" />

 How to Run
1. Install Java

Make sure Java JDK 17 or later is installed.

Check installation:

java --version
2. Install JavaFX SDK

Download JavaFX SDK from:

https://openjfx.io

Extract the SDK to a known location.

Example:

C:\javafx-sdk
3. Compile the Program

Open terminal/command prompt inside the project folder and run:

javac --module-path "PATH_TO_FX" --add-modules javafx.controls *.java

Example:

javac --module-path "C:\javafx-sdk\lib" --add-modules javafx.controls *.java
4. Run the Application
java --module-path "PATH_TO_FX" --add-modules javafx.controls ApartmentGUI

Example:

java --module-path "C:\javafx-sdk\lib" --add-modules javafx.controls ApartmentGUI
5. Using the Application
Enter:
Street Name
Apartment Number
Number of Beds
Rent Amount
Click:
Add Apartment → saves valid apartment
Display Apartments → shows all valid apartments
Clear Fields → resets all fields
Invalid inputs will display popup error messages.
Project Structure
ApartmentException.java
Apartment.java
ApartmentGUI.java
README.md
