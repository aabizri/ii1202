import edu.princeton.cs.introcs.StdDraw;

public class Main {
    public static void main(String[] args) {
        // Create display
        Display disp = new Display(64);
        disp.start();

        // Create players that share the same display
        PlayerInterface cross = new HumanPlayer(disp);
        PlayerInterface round = new RandomPlayer();

        // Create game
        Game game = new Game(cross, round);
        disp.update(game.grid);

        for (int roundNumber = 0; ; roundNumber++) {
            disp.print((new StringBuilder("Round ").append(roundNumber).toString()));
            StdDraw.pause(500);

            // Print
            System.out.printf("Round %d started\n", roundNumber);

            // Main loop
            while (game.computeState() == 0) {
                game.playTurn();
            }
            disp.update(game.grid);

            // Winning display
            StdDraw.setPenColor(StdDraw.BLACK);
            int state = game.computeState();
            switch (state) {
                case 1:
                    System.out.println("Cross WON !");
                    disp.print("Cross Won !");
                    break;
                case 2:
                    System.out.println("Round WON !");
                    disp.print("Round Won !");
                    break;
                case 3:
                    System.out.println("Stalemate :(");
                    disp.print("Stalemate :(");
            }

            // Reset game
            StdDraw.pause(500);
            disp.clear();
            game.reset();
        }
    }
}
