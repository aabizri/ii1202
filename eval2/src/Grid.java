public class Grid {
    // Constants for player side
    public static final int EMPTY = 0;
    public static final int CROSS = 1;
    public static final int ROUND = 2;

    // Grid
    // 0: Empty
    // 1: Cross
    // 2: Round
    private int[] table = new int[]{
            EMPTY, EMPTY, EMPTY, // Line 0: cells 0, 1, 2
            EMPTY, EMPTY, EMPTY, // Line 1: cells 3, 4, 5
            EMPTY, EMPTY, EMPTY, // Line 2: cells 6, 7, 8
    };

    public void set(int index, int value) {
        table[index] = value;
    }

    public void set(int x, int y, int value) {
        int index = XYToIndex(x,y);
        set(index,value);
    }

    public int get(int index) {
        return table[index];
    }

    public int get(int x, int y) {
        int index = XYToIndex(x,y);
        return get(index);
    }

    // Reset grid
    public void reset() {
        for (int i = 0; i < 9; i++) {
            this.table[i] = EMPTY;
        }
    }

    /**
     * @param index index of the table
     * @return Y value
     */
    public static int indexToY(int index) {
        int y = 0;
        if (index >= 6) {
            y = 2;
        } else if (index >= 3) {
            y = 1;
        }
        return y;
    }

    /**
     * @param index index of the table
     * @return X value
     */
    public static int indexToX(int index) {
        return index - 3 * indexToY(index);
    }

    /**
     * @param column
     * @param line
     * @return
     */
    public static int XYToIndex(int column, int line) {
        return 3 * line + column;
    }
}
