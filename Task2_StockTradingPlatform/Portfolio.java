import java.util.*;

public class Portfolio {
    private Map<Stock, Integer> holdings = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();
    private double balance = 10000; // Starting balance

    public double getBalance() {
        return balance;
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;

        if (cost > balance) {
            System.out.println("Not enough balance!");
            return;
        }

        holdings.put(stock, holdings.getOrDefault(stock, 0) + quantity);
        balance -= cost;

        transactions.add(new Transaction(stock, quantity, "BUY"));

        System.out.println("Stock bought successfully!");
    }

    public void sellStock(Stock stock, int quantity) {
        if (!holdings.containsKey(stock) || holdings.get(stock) < quantity) {
            System.out.println("Not enough stocks to sell!");
            return;
        }

        holdings.put(stock, holdings.get(stock) - quantity);
        balance += stock.getPrice() * quantity;

        transactions.add(new Transaction(stock, quantity, "SELL"));

        System.out.println("Stock sold successfully!");
    }

    public void viewPortfolio() {
        System.out.println("\n--- Your Portfolio ---");
        for (Stock s : holdings.keySet()) {
            System.out.println(s.getName() + " : " + holdings.get(s));
        }
        System.out.println("Balance: " + balance);
    }

    public void showTransactions() {
        System.out.println("\n--- Transaction History ---");
        for (Transaction t : transactions) {
            t.displayTransaction();
        }
    }
}
