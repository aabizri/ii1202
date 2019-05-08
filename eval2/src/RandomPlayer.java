import java.util.Random;

/**
 * RandomPlayer is a computer player playing random open tiles
 */
public class RandomPlayer implements PlayerInterface{
    public int decide(Grid grid, int turn) {
        // Retrieve all open cells
        int[] openCells = new int[9-turn];
        for (int i = 0, j = 0; i < 9; i++) {
            if (grid.get(i) != 0) continue;
            openCells[j] = i;
            j++;
        }

        // Randomly choose from one of them
        Random rand = new Random();
        int n = rand.nextInt(9-turn);
        return openCells[n];
    }
}
