import java.util.*;

public class HotelService {

    static List<Room> rooms = new ArrayList<>();
    static List<Reservation> reservations = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void loadRooms() {
        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Deluxe", 2500));
        rooms.add(new Room(103, "Suite", 4000));
        rooms.add(new Room(104, "Standard", 1500));
    }

    public static void searchRooms() {
        System.out.print("Enter room category: ");
        String category = sc.next();

        boolean found = false;
        for (Room r : rooms) {
            if (r.category.equalsIgnoreCase(category) && r.isAvailable) {
                System.out.println("Room ID: " + r.roomId + " | Price: ₹" + r.price);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No rooms available in this category.");
        }
    }

    public static void bookRoom() {
        System.out.print("Enter Room ID: ");
        int roomId = sc.nextInt();

        for (Room r : rooms) {
            if (r.roomId == roomId && r.isAvailable) {
                System.out.print("Enter customer name: ");
                sc.nextLine();
                String name = sc.nextLine();

                System.out.print("Enter number of days: ");
                int days = sc.nextInt();

                double total = r.price * days;
                Payment.processPayment(total);

                int resId = reservations.size() + 1;
                reservations.add(new Reservation(resId, roomId, name, days, total));
                r.isAvailable = false;

                System.out.println("Room booked successfully! Reservation ID: " + resId);
                return;
            }
        }
        System.out.println("Room not available.");
    }

    public static void cancelReservation() {
        System.out.print("Enter Reservation ID: ");
        int resId = sc.nextInt();

        Iterator<Reservation> it = reservations.iterator();
        while (it.hasNext()) {
            Reservation res = it.next();
            if (res.reservationId == resId) {
                it.remove();
                for (Room r : rooms) {
                    if (r.roomId == res.roomId) {
                        r.isAvailable = true;
                    }
                }
                System.out.println("Reservation cancelled successfully.");
                return;
            }
        }
        System.out.println("Reservation not found.");
    }

    public static void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }

        for (Reservation r : reservations) {
            System.out.println("Reservation ID: " + r.reservationId);
            System.out.println("Customer: " + r.customerName);
            System.out.println("Room ID: " + r.roomId);
            System.out.println("Days: " + r.days);
            System.out.println("Total Amount: ₹" + r.totalAmount);
            System.out.println("-------------------------");
        }
    }
}
