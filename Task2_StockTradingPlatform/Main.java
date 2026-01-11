import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Market market = new Market();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        User user = new User(name);

        int choice;

        do {
            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    market.displayMarket();
                    break;

                case 2:
                    market.displayMarket();
                    System.out.print("Enter Stock ID: ");
                    int buyId = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int buyQty = sc.nextInt();

                    Stock buyStock = market.getStockById(buyId);
                    if (buyStock != null) {
                        user.getPortfolio().buyStock(buyStock, buyQty);
                    } else {
                        System.out.println("❌ Invalid stock ID");
                    }
                    break;

                case 3:
                    market.displayMarket();
                    System.out.print("Enter Stock ID: ");
                    int sellId = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();

                    Stock sellStock = market.getStockById(sellId);
                    if (sellStock != null) {
                        user.getPortfolio().sellStock(sellStock, sellQty);
                    } else {
                        System.out.println("❌ Invalid stock ID");
                    }
                    break;

                case 4:
                    user.getPortfolio().viewPortfolio();
                    break;

                case 5:
                    System.out.println("Thank you for using the platform!");
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
