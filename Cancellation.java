import java.sql.*;
import java.util.Scanner;

public class Cancellation {
    public static void cancelTicket() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter PNR: ");
        int pnr = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM reservations WHERE pnr=?");
            ps.setInt(1, pnr);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Passenger: " + rs.getString("name"));
                System.out.println("Train: " + rs.getString("train_name"));

                System.out.print("Confirm Cancellation (yes/no): ");
                String confirm = sc.next();

                if (confirm.equalsIgnoreCase("yes")) {
                    PreparedStatement del =
                        con.prepareStatement("DELETE FROM reservations WHERE pnr=?");
                    del.setInt(1, pnr);
                    del.executeUpdate();
                    System.out.println("❌ Ticket Cancelled Successfully");
                }
            } else {
                System.out.println("PNR Not Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}