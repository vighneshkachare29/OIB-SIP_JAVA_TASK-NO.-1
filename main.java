package onlinereservation;
import java.util.Scanner;

public class main {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== ONLINE RESERVATION SYSTEM ===");

        if (!Login.validate()) {   
            System.out.println("Invalid Login!");
            return;
        }

        while (true) {
            System.out.println("\n1. Reservation");
            System.out.println("2. Cancellation");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Reservation.bookTicket();
                    break;

                case 2:
                    Cancellation.cancelTicket();
                    break;

                case 3:
                    System.out.println("Logged Out!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}
