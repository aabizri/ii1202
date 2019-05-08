public class Vehicle {
    private int size;
    protected int passengerCount;

    protected Vehicle(int size, int passengerCount) {
        this.size = size;
        this.passengerCount = passengerCount;
    }

    public int getSize() {
        return size;
    }

    public int getPassengerCount() {
        return passengerCount;
    }
}
