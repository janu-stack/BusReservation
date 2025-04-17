package busResev;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Booking {
    String passengerName;
    int busNo;
    Date date;

    // Constructor
    Booking() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter name of passenger: ");
        passengerName = scanner.nextLine();

        System.out.print("Enter bus no: ");
        busNo = scanner.nextInt();

        System.out.print("Enter date (dd-MM-yyyy): ");
        String dateInput = scanner.next();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Booking failed.");
            date = new Date(); // fallback to current date
        }

        // ❗️ Do not close the scanner as it uses System.in
    }

    // Check seat availability
    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity = 0;

        for (Bus bus : buses) {
            if (bus.getBusNo() == busNo) {
                capacity = bus.getCapacity();
            }
        }

        int booked = 0;
        for (Booking b : bookings) {
            if (b.busNo == busNo && b.date.equals(date)) {
                booked++;
            }
        }

        return booked < capacity;
    }
    public void displayBooking() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Name: " + passengerName + ", Bus No: " + busNo + ", Date: " + dateFormat.format(date));
    }
    public void saveToDatabase() {
        try {
            java.sql.Connection con = DBConnection.getConnection();
            java.sql.PreparedStatement ps = con.prepareStatement(
                "INSERT INTO bookings (passenger_name, bus_no, travel_date) VALUES (?, ?, ?)"
            );
            ps.setString(1, passengerName);
            ps.setInt(2, busNo);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(3, sqlDate);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
