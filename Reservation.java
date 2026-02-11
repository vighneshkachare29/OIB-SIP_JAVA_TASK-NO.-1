package onlinereservation;
import java.sql.*;
import java.util.Scanner;

public class Reservation {
	 public static void bookTicket() {
	        Scanner sc = new Scanner(System.in);

	        try {
	            Connection con = DBConnection.getConnection();

	            PreparedStatement ps = con.prepareStatement(
	                "INSERT INTO reservations(name, train_no, train_name, class_type, journey_date, source, destination) VALUES(?,?,?,?,?,?,?)",
	                Statement.RETURN_GENERATED_KEYS
	            );

	            System.out.print("Name: ");
	            ps.setString(1, sc.nextLine());

	            System.out.print("Train No: ");
	            ps.setString(2, sc.nextLine());

	            System.out.print("Train Name: ");
	            ps.setString(3, sc.nextLine());

	            System.out.print("Class Type: ");
	            ps.setString(4, sc.nextLine());

	            System.out.print("Journey Date (YYYY-MM-DD): ");
	            ps.setString(5, sc.nextLine());

	            System.out.print("From: ");
	            ps.setString(6, sc.nextLine());

	            System.out.print("To: ");
	            ps.setString(7, sc.nextLine());

	            ps.executeUpdate();

	            // 🔥 FETCH GENERATED PNR
	            ResultSet rs = ps.getGeneratedKeys();
	            if (rs.next()) {
	                int pnr = rs.getInt(1);
	                System.out.println("✅ Reservation Successful!");
	                System.out.println("🎫 Your PNR Number is: " + pnr);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	
}
