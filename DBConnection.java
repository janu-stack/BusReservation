package busResev;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");  // Debugging line
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bus_reservation",
                "root",
                "admin123"  // Replace this with your MySQL password
            );
            if (con != null) {
                System.out.println("Connection Successful");  // Debugging line
            }
        } catch (Exception e) {
            e.printStackTrace();  // This will print any driver-related issues
        }
        return con;
    }
}
