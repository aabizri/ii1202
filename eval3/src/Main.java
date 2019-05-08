public class Main {
    public static void main(String[] args) {
        System.out.println("Launching static (Q4) simulation");
        FerryEmbarcation staticEmbarcation = FerryEmbarcation.staticConfig();
        staticEmbarcation.simulate();

        System.out.println("Launching random (Q8) simulation");
        FerryEmbarcation randomEmbarcation = FerryEmbarcation.randomConfig();
        randomEmbarcation.simulate();
    }
}
