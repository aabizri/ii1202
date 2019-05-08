import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class FerryEmbarcation {
    private Ferry ferry;
    private ArrayList<Vehicle> vehicles;

    public FerryEmbarcation(Ferry ferry, ArrayList<Vehicle> vehicles) {
        this.ferry = ferry;
        this.vehicles = vehicles;
    }

    public void simulate() {
        System.out.printf("Starting Simulation for Ferry \"%s\" [Bridges: %d] with %d vehicles awaiting...\n",ferry.getName(),ferry.calculateBridgeCount(),vehicles.size());
        for (Vehicle v: vehicles) {
            if (ferry.evaluateIsFull()) {
                break;
            }

            if (!ferry.canLoad(v)) {
                continue;
            }

            try {
                Ticket t = ferry.load(v);
                System.out.printf("Success: vehicle was successfully loaded to bridge \"%s\" for a ticket price of %d€\n",t.getBridge().getName(),t.getPrice());
            } catch (Exception e) {
                System.out.printf("Error: Exception encountered on vehicle: %s",e.toString());
            }
        }
        System.out.println("End of simulation.");
    }

    /**
     * staticConfig generates the config as indicated in Question 4
     */
    public static FerryEmbarcation staticConfig() {
        ArrayList<Bridge> bridges = new ArrayList<>();
        bridges.add(new Bridge("S - small",15));
        bridges.add(new Bridge("B - big",20));
        Ferry ferry = new Ferry("SFS - Special Ferry Services",200,bridges);

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car(1));
        vehicles.add(new Car(4));
        vehicles.add(new Bus(3,20));

        return new FerryEmbarcation(ferry,vehicles);
    }

    /**
     * randomConfig generates the config as indicated in Question 8
     */
    public static FerryEmbarcation randomConfig() {
        Ferry ferry = generateFerry();
        ArrayList<Vehicle> vehicles = generateVehicles();
        return new FerryEmbarcation(ferry,vehicles);
    }

    public static Ferry generateFerry() {
        int ferryNumber = ThreadLocalRandom.current().nextInt(0,600);
        String ferryName = "Ferry #" + Integer.toString(ferryNumber);

        int passengerCapacity = ThreadLocalRandom.current().nextInt(120,350);

        int bridgeCount = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        ArrayList<Bridge> bridges = new ArrayList<>();
        for (int i = 0; i < bridgeCount; i++) {
            bridges.add(generateBridge());
        }

        return new Ferry(ferryName,passengerCapacity,bridges);
    }

    public static Bridge generateBridge() {
        int placeCount = ThreadLocalRandom.current().nextInt(12,40+1);

        int bridgeNumber = ThreadLocalRandom.current().nextInt(0,1200);
        String bridgeName = "Bridge #" + Integer.toString(bridgeNumber);

        return new Bridge(bridgeName,placeCount);
    }

    public static ArrayList<Vehicle> generateVehicles() {
        int maxAmount = 120;
        ArrayList<Vehicle> vehicles = new ArrayList<>(maxAmount);
       for (int i = 0; i < maxAmount; i++) {
            vehicles.add(generateVehicle());
       }
       return vehicles;
    }

    public static Vehicle generateVehicle() {
        int sizeToken = ThreadLocalRandom.current().nextInt(0,10);

        int size;
        if (sizeToken < 7) {
            size = 1;
        } else if (sizeToken == 7) {
            size = 2;
        } else if (sizeToken == 8) {
            size = 3;
        } else {
            size = 4;
        }

        int minPassengers;
        int maxPassengers;
        switch (size) {
            case 1:
                minPassengers = 1;
                maxPassengers = 5;
                break;
            case 2:
                minPassengers = 2;
                maxPassengers = 12;
            case 3:
                minPassengers = 2;
                maxPassengers = 30;
            default:
                minPassengers = 15;
                maxPassengers = 50;
        }
        int passengerCount = ThreadLocalRandom.current().nextInt(minPassengers,maxPassengers+1);

        Vehicle vehicle;
        switch (size) {
            case 1:
                vehicle = new Car(passengerCount);
                break;
            default:
                vehicle = new Bus(size,passengerCount);
        }
        return vehicle;
    }
}
