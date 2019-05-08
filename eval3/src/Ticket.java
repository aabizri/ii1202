public class Ticket {
    private int price;
    private Bridge bridge;

    public Ticket(Vehicle v, Bridge b) {
        this.price = 75 * v.getSize() + 15 * v.getPassengerCount();
        this.bridge = b;
    }

    public int getPrice() {
        return this.price;
    }

    public Bridge getBridge() {
        return this.bridge;
    }
}