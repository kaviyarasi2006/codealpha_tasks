import java.io.Serializable;

public class Reservation implements Serializable {
    public int reservationId;
    public int roomId;
    public String customerName;
    public int days;
    public double totalAmount;

    public Reservation(int reservationId, int roomId, String customerName, int days, double totalAmount) {
        this.reservationId = reservationId;
        this.roomId = roomId;
        this.customerName = customerName;
        this.days = days;
        this.totalAmount = totalAmount;
    }
}
