import java.util.ArrayList;

public class Ferry {
    private String name;
    private ArrayList<Bridge> bridges;
    private int passengerCapacity;

    public Ferry(String name, int passengerCapacity, ArrayList<Bridge> bridges) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.bridges = bridges;
    }

    public String getName() {
        return this.name;
    }

    public int calculateBridgeCount() {
        return bridges.size();
    }
    private int calculatePassengerCount() {
        int count = 0;
        for (Bridge b: this.bridges) {
            count += b.calculatePassengerCount();
        }
        return count;
    }

    private boolean evaluateIsPassengerCapacityReached() {
        return this.calculatePassengerCount() == this.passengerCapacity;
    }

    private boolean evaluateIsEveryBridgeSpaceCapacityReached() {
        return this.bridges.stream().anyMatch(Bridge::evaluateIsSpaceCapacityReached);
    }

    public boolean evaluateIsFull() {
        return evaluateIsPassengerCapacityReached() || evaluateIsEveryBridgeSpaceCapacityReached();
    }

    private Bridge findBridgeWithFreeSpace(int spacesRequired) {
        return this.bridges.stream().filter(b -> b.canLoad(spacesRequired)).findAny().orElse(null);
    }

    public boolean canLoad(Vehicle v) {
        return !(this.evaluateIsFull() ||
            this.calculatePassengerCount() + v.passengerCount > this.passengerCapacity ||
            findBridgeWithFreeSpace(v.passengerCount) == null);
    }

    public Ticket load(Vehicle v) throws Exception {
        if (!canLoad(v)) {
            throw new Exception("No space left for that vehicle");
        }

        Bridge availableBridge = findBridgeWithFreeSpace(v.getSize());

        availableBridge.load(v);

        return new Ticket(v,availableBridge);
    }
}
