Bus Reservation System
This is a Java-based Bus Reservation System that allows passengers to book, cancel, and view their bus reservations. The system uses JDBC to connect to a MySQL database to store booking details.

Features
Book a ticket: Allows the user to book a ticket by providing passenger details and travel information.

Cancel a ticket: Provides functionality to cancel an existing booking.

View all bookings: Displays a list of all current bookings.

Database integration: Uses MySQL to store and retrieve booking details securely.

Exception Handling: Handles invalid inputs, database errors, and other edge cases.

Technologies Used
Java: Core programming language for application logic.

JDBC: Java Database Connectivity to interact with the MySQL database.

MySQL: Relational database for storing passenger booking information.

Eclipse IDE: Development environment used for building and testing the project.

Getting Started
To get started with this project, follow these steps:

Prerequisites
Java 8 or higher

MySQL

Eclipse IDE or any Java IDE

Setting Up
Clone the repository to your local machine:

bash
Copy
Edit
git clone https://github.com/jananisekar2104/Bus-Reservation-System.git
Create a MySQL Database:

Create a new database called bus_reservation.

Run the following SQL commands to set up the required table:

sql
Copy
Edit
CREATE TABLE bookings (
  id INT AUTO_INCREMENT PRIMARY KEY,
  passenger_name VARCHAR(100),
  bus_no INT,
  travel_date DATE
);
Configure the Database Connection:

In the DBConnection.java file, update the MySQL username and password:

java
Copy
Edit
"jdbc:mysql://localhost:3306/bus_reservation", "root", "your_password"
Run the Application:

Open BusDemo.java and run the program.

Interact with the menu-driven system for booking, canceling, and viewing tickets.

Usage
Once the system is running, you will be presented with a menu:

Book Ticket: Enter passenger name, bus number, and travel date to book a ticket.

Cancel Ticket: Provide the booking details to cancel an existing reservation.

View All Bookings: View all bookings currently in the system.
Exit: Exit the application.

Contributing
Feel free to fork the repository, make changes, and create pull requests. Contributions are always welcome!

