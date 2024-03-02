# GestionMedicamentsPharmacie

## Description
GestionMedicamentsPharmacie is an application for managing the acquisition of medicines in a pharmacy. It allows users to add, modify, search, and delete medicines from the database.

## Features
- **Add Medicine:** Users can add a new medicine by providing information such as code, name, price, date, and quantity.
- **Modify Medicine:** Existing medicines can be modified by updating their information.
- **Search Medicine:** Users can search for medicines based on their code.
- **Delete Medicine:** Medicines can be removed from the database using their code.
- **Dashboard:** Provides a dashboard with a list of medicines and the ability to filter them based on quantity.

## Technologies Used
- **Java:** The main programming language for the application.
- **Swing:** Used for creating the graphical user interface.
- **MySQL:** Database management system for storing medicine information.
- **JDBC:** Java Database Connectivity for connecting and interacting with the MySQL database.
- **rs2xml.jar:** External library for converting database results into a format compatible with Swing JTable.

## Installation
1. Import the included SQL file `ihm.sql` into your MySQL database.
2. Add the `mysql-connector-j-8.0.31.jar` and `rs2xml.jar` to your project's classpath.

## Usage
1. Run the `Main.java` file to start the application.
2. The main dashboard allows you to search for medicines based on quantity and displays a list of medicines.
3. Navigate to the "Nouveau" section to add a new medicine.
4. Click on a medicine in the list to modify or delete it.

## Contributors
- OUARAS Khelil Rafik
