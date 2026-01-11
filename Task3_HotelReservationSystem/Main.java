public class Main {
    public static void main(String[] args) {

        HotelService.loadRooms();

        while (true) {
            System.out.println("\n=== HOTEL RESERVATION SYSTEM ===");
            System.out.println("1. Search Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Reservations");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = HotelService.sc.nextInt();

            switch (choice) {
                case 1 -> HotelService.searchRooms();
                case 2 -> HotelService.bookRoom();
                case 3 -> HotelService.cancelReservation();
                case 4 -> HotelService.viewReservations();
                case 5 -> {
                    System.out.println("Thank you!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}

