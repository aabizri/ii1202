public class Main {
    static int[][] tables = {
            {15,14,13,12,11,10,9,8,7,6,5,4,3,2,1},
            {9,2,3,4,5,6,7,15,1,10,11,12,13,14,8},
            {3,4,1,2,5,6,7,8,9,10,11,13,12,15,14},
            {6,14,10,5,11,3,4,2,15,1,13,8,12,9,7},
            {6,8,10,5,10,3,4,2,1,1,10,8,1,9,7},
    };

    static Sort[] algos = {
            new BubbleSort(),
            new SelectionSort(),
            new QuickSort(),
    };

    public static void main(String[] args) {
        for (int i = 0; i < algos.length; i++) {
            Sort alg = algos[i];
            System.out.printf("Test de l'algorithme \"%s\"\n",alg.getClass().getSimpleName());
            for (int j = 0; j < tables.length; j++) {
                int[] in = tables[j];
                int[] out = alg.sort(in.clone());
                System.out.printf("\t%s\t->\t%s\n", PrintTab.format(in), PrintTab.format(out));
            }
        }
    }
}
