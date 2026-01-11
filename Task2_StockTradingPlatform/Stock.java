import java.util.Objects;

public class Stock {
    private int id;
    private String name;
    private double price;

    public Stock(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayStock() {
        System.out.println(id + " | " + name + " | " + price);
    }

    // VERY IMPORTANT for HashMap to work correctly
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;
        Stock stock = (Stock) o;
        return id == stock.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
