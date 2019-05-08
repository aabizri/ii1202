import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class Display {
    private static final Color backgroundColor = StdDraw.WHITE;

    public int size;

    public Display(int size) {
        this.size = size;
    }

    public void start() {
        // Start Graphics
        StdDraw.setXscale(0, size);
        StdDraw.setYscale(size, 0);
    }

    public void stop() {
        StdDraw.clear();
    }

    // Prepare graphics
    public void update(Grid grid) {
        this.clear();

        // Show grid line half width
        double gridLineSize = size / 50;

        // Color the pen
        StdDraw.setPenColor(StdDraw.BLACK);

        // Show columns
        StdDraw.filledRectangle(size / 3, size / 2, gridLineSize, size);
        StdDraw.filledRectangle(2 * size / 3, size / 2, gridLineSize, size);

        // Show lines
        StdDraw.filledRectangle(size, size / 3, size, gridLineSize);
        StdDraw.filledRectangle(size, 2 * size / 3, size, gridLineSize);

        // Fill it
        for (int index = 0; index < 9; index++) {
            // Get value
            int val = grid.get(index);

            // If 0 (empty), skip
            if (val == 0) {
                continue;
            }

            // Evaluate whether it is a cross or a round
            boolean isCross = (val == 1);

            // Color the pen
            Color color = isCross ? StdDraw.GREEN : StdDraw.RED;
            StdDraw.setPenColor(color);

            // Linear to X/Y
            int col = Grid.indexToX(index);
            int line = Grid.indexToY(index);

            // Calculate coordinates to update
            int x = col * size / 3 + size / 6;
            int y = line * size / 3 + size / 6;

            // Show
            if (isCross) {
                StdDraw.filledRectangle(x, y, size / 10, size / 10);
            } else {
                StdDraw.filledCircle(x, y, size / 10);
            }
        }
    }

    // Display text on it
    public void print(String text) {
        StdDraw.text(this.size / 2, this.size / 2, text);
    }

    // Clear the display
    public void clear() {
        StdDraw.clear(backgroundColor);
    }
}
