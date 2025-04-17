package busResev;

import java.util.ArrayList;
import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args) {

        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        buses.add(new Bus(1, true, 2));
        buses.add(new Bus(2, false, 50));
        buses.add(new Bus(3, true, 48));

        Scanner scanner = new Scanner(System.in);
        int userOpt;

        for (Bus b : buses) {
            b.displayBusInfo();
        }

        do {
            System.out.println("\n1. Book Ticket\n2. Cancel Ticket\n3. View All Bookings\n4. Exit");
            userOpt = scanner.nextInt();
            scanner.nextLine(); // flush newline

            switch (userOpt) {
                case 1:
                    Booking booking = new Booking();
                    if (booking.isAvailable(bookings, buses)) {
                        bookings.add(booking);
                        booking.saveToDatabase();

                        System.out.println("Your booking is confirmed.");
                    } else {
                        System.out.println("Sorry. Bus is full. Try another bus or date.");
                    }
                    break;

                case 2:
                    System.out.println("Enter name of passenger to cancel:");
                    String nameToCancel = scanner.nextLine();
                    boolean removed = bookings.removeIf(b -> b.passengerName.equalsIgnoreCase(nameToCancel));
                    if (removed) {
                        System.out.println("Booking cancelled successfully.");
                    } else {
                        System.out.println("No booking found for the given name.");
                    }
                    break;

                case 3:
                    System.out.println("All Bookings:");
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings available.");
                    } else {
                        for (Booking b : bookings) {
                            b.displayBooking();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using Bus Reservation System.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (userOpt != 4);

        scanner.close();
    }
}
