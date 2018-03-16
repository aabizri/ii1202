public class Table implements Command{
    public static void print2D(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%d\t", table[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[][] table = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        print2D(table);
    }

    public void command(String[] args) {
        main(args);
    }

    public String name() {
        return "Table";
    }
}
