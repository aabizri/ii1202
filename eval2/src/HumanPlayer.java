import edu.princeton.cs.introcs.StdDraw;

public class HumanPlayer implements PlayerInterface {
    private Display display;

    public HumanPlayer(Display display) {
        this.display = display;
    }

    public int input() {
        // Get value
        double cursorX;
        double cursorY;
        while (true) {
            // Pause
            StdDraw.pause(50);

            // Check press
            if (!StdDraw.mousePressed()) {
                continue;
            }

            // get values
            cursorX = StdDraw.mouseX();
            cursorY = StdDraw.mouseY();
            break;
        }

        // Interpret
        int size = this.display.size;
        int x = (int) (cursorX / (size/3));
        int y = (int) (cursorY / (size/3));

        // Calculate
        return Grid.XYToIndex(x,y);
    }

    /**
     * @param grid the grid on which to base decisions
     * @param turn the turn number
     * @return the choice of which cell to play
     */
    public int decide(Grid grid, int turn) {
        // Firstly, show the player
        this.display.update(grid);

        // Then, require his input
        return input();
    }
}
