import java.util.ArrayList;

public class Bridge {
    private String name;
    private int spaceCapacity;
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    public Bridge(String name, int capacity) {
        this.name = name;
        this.spaceCapacity = capacity;
    }

    public String getName() {
        return this.name;
    }

    public int calculatePassengerCount() {
        return vehicles.stream().mapToInt(Vehicle::getSize).sum();
    }

    private int calculateOccupiedCapacity() {
        return vehicles.stream().mapToInt(Vehicle::getSize).sum();
    }

    public boolean evaluateIsSpaceCapacityReached() {
        return this.calculateOccupiedCapacity() >= this.spaceCapacity;
    }

    public boolean canLoad(int requiredSpaces) {
        return this.calculateOccupiedCapacity() + requiredSpaces <= this.spaceCapacity;
    }

    public void load(Vehicle v) throws Exception {
        if (!canLoad(v.getSize())) {
            throw new Exception("Cannot load: not enough places left");
        }
        this.vehicles.add(v);
    }
}
