import java.io.Serializable;

public class Room implements Serializable {
    public int roomId;
    public String category;
    public double price;
    public boolean isAvailable;

    public Room(int roomId, String category, double price) {
        this.roomId = roomId;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }
}
