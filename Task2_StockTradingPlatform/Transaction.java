import java.util.Date;

public class Transaction {
    private Stock stock;
    private int quantity;
    private String type; // BUY or SELL
    private double price;
    private Date date;

    public Transaction(Stock stock, int quantity, String type) {
        this.stock = stock;
        this.quantity = quantity;
        this.type = type;
        this.price = stock.getPrice();
        this.date = new Date();
    }

    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public double getTotalAmount() {
        return price * quantity;
    }

    public void displayTransaction() {
        System.out.println(
            type + " | " +
            stock.getName() + " | Qty: " + quantity +
            " | Price: ₹" + price +
            " | Total: ₹" + getTotalAmount() +
            " | Date: " + date
        );
    }
}
