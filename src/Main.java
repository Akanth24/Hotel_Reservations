import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/hotel_reservation_db";
    private static final String username = "root";
    private static final String password = "Akanth24@";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            while (true) {
                System.out.println();
                System.out.println("HOTEL MANAGEMENT SYSTEM");
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. Reserve a room");
                System.out.println("2. View Reservations");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservations");
                System.out.println("5. Delete Reservations");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        reserveRoom(connection, scanner);
                        break;
                    case 2:
                        viewReservations(connection);
                        break;
                    case 3:
                        getRoomNumber(connection, scanner);
                        break;
                    case 4:
                        updateReservation(connection, scanner);
                        break;
                    case 5:
                        deleteReservation(connection, scanner);
                        break;
                    case 0:
                        exit();
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    private static void reserveRoom(Connection connection, Scanner scanner) {
        ReserveRoom.reserveRoom(connection, scanner);
    }

    private static void viewReservations(Connection connection) throws SQLException {
        ViewReservations.viewReservations(connection);
    }


    private static void getRoomNumber(Connection connection, Scanner scanner) {
        GetRoomNumber.getRoomNumber(connection, scanner);
    }

    private static void updateReservation(Connection connection, Scanner scanner) {
        UpdateReservation.updateReservation(connection, scanner);
    }

    private static void deleteReservation(Connection connection, Scanner scanner) {
        DeleteReservation.deleteReservation(connection, scanner);
    }

    public static void exit() throws InterruptedException {
        System.out.print("Exiting System");
        int i = 5;
        while (i != 0) {
            System.out.print(".");
            Thread.sleep(500);
            i--;
        }
        System.out.println();
        System.out.println("ThankYou For Using Hotel Reservation System!!!");
    }
}