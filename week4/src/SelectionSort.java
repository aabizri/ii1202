public class SelectionSort implements Sort{
    public static int[] selectionSort(int[] in) {
        int minIndex;
        for (int i = 0; i < in.length-1; i++) {
            // On trouve l'indice de l'élement minimum
            minIndex = i;
            for (int j = i + 1; j < in.length; j++) {
                if (in[j] < in[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap
            if (minIndex != i) {
                int tmp = in[i];
                in[i] = in[minIndex];
                in[minIndex] = tmp;
            }
        }
        return in;
    }

    public int[] sort(int[] in) {
        return selectionSort(in);
    }
}
