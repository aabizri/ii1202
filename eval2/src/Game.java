public class Game {

    // Grid
    public Grid grid = new Grid();

    // Players
    public PlayerInterface crossPlayer;
    public PlayerInterface roundPlayer;

    // Current turn
    public int turn = 0;

    // Create a new game, to start we simply give the graphical size of the grid
    public Game(PlayerInterface cross, PlayerInterface round) {
        // Set players
        this.crossPlayer = cross;
        this.roundPlayer = round;
    }

    // Reset grid
    public void reset() {
        this.turn = 0;
        this.grid.reset();
    }

    // Turn playing method
    public void playTurn() {
        // If turn is pair, then it is cross's time to shine, else it's round
        boolean isCrossTurn = false;
        if (this.turn % 2 == 0) {
            isCrossTurn = true;
        }

        // Ask player for choice
        PlayerInterface player = isCrossTurn ? crossPlayer : roundPlayer;

        // Coordinate choice
        int choice = player.decide(this.grid, this.turn);

        // Validate it
        boolean ok = this.validatePlay(choice);
        if (!ok) {
            playTurn();
            return;
        }

        // Act
        this.registerPlay(choice, isCrossTurn);

        // Played
        System.out.printf("Turn %d has been played by %s for cell %d\n", turn, isCrossTurn ? "cross" : "round", choice);

        // Step
        this.turn++;
    }

    // Validate play
    private boolean validatePlay(int choice) {
        // Check if empty
        return this.grid.get(choice) == 0;
    }

    // Register play
    private void registerPlay(int choice, boolean isCross) {
        // Check if empty
        this.grid.set(choice, isCross ? Grid.CROSS : Grid.ROUND);
    }

    // State ? (4 values: 0 => Still Playing, 1 => Cross Victory, 2 => Round Victory, 3 => Stalemate)
    public int computeState() {

        // Boolean arrays validators
        boolean[][] validators = new boolean[][]{
                new boolean[]{
                        true, true, true,
                        false, false, false,
                        false, false, false,
                },
                new boolean[]{
                        false, false, false,
                        true, true, true,
                        false, false, false,
                },
                new boolean[]{
                        false, false, false,
                        false, false, false,
                        true, true, true,
                },
                new boolean[]{
                        true, false, false,
                        true, false, false,
                        true, false, false,
                },
                new boolean[]{
                        false, true, false,
                        false, true, false,
                        false, true, false,
                },
                new boolean[]{
                        false, false, true,
                        false, false, true,
                        false, false, true,
                },
                new boolean[]{
                        true, false, false,
                        false, true, false,
                        false, false, true,
                },
                new boolean[]{
                        false, false, true,
                        false, true, false,
                        true, false, false,
                },
        };

        // Run them
        for (boolean[] validator : validators) {
            int figureCursor = 0;
            for (int i = 0; i < 9; i++) {
                // Skip if not concerned with it
                if (!validator[i]) {
                    continue;
                }

                // If empty while being validated, break out of the inner loop
                if (this.grid.get(i) == 0) {
                    figureCursor = 0;
                    break;
                }

                // Check that it's the same figure as the last figure validated
                if (this.grid.get(i) != figureCursor && figureCursor != 0) {
                    figureCursor = 0;
                    break;
                }

                figureCursor = this.grid.get(i);
            }
            if (figureCursor != 0) {
                return figureCursor;
            }
        }

        // Check for stalemate
        if (this.turn > 8) {
            return 3;
        }

        return 0;
    }
}
