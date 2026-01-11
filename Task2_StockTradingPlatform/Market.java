import java.util.ArrayList;

public class Market {
    private ArrayList<Stock> stocks = new ArrayList<>();

    public Market() {
        stocks.add(new Stock(1, "Apple", 150));
        stocks.add(new Stock(2, "Tesla", 700));
        stocks.add(new Stock(3, "Google", 2800));
        stocks.add(new Stock(4, "Amazon", 3300));
    }

    public void displayMarket() {
        System.out.println("\n--- Market Data ---");
        for (Stock s : stocks) {
            s.displayStock();
        }
    }

    public Stock getStockById(int id) {
        for (Stock s : stocks) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
