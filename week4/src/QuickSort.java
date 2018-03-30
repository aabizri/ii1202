public class QuickSort implements Sort{
    public static int[] partition(int[] tab, int start, int end) {
        int pivotValue = tab[start + (end-start)/2];
        int i = start - 1;
        int j = end;
        while (i < j)
        {
            for (i++; tab[i] < pivotValue; i++);
            for (j--; tab[j] > pivotValue; j--);
            if (i < j) {
                int tmp = tab[i];
                tab[i] = tab[j];
                tab[j] = tmp;
            }
        }
        int[] ret = {i,j};
        return ret;
    }

    public static void quickSort(int[] tab, int start, int end) {
        System.out.printf("quickSort with start=%d end=%d\n",start,end);
        // Si la longueur est de 1, return
        if (end - start <= 1) {
            return;
        }

        // On partitionne et on pivote
        int[] pivot = partition(tab, start, end);
        if (start < pivot[1]){
            quickSort(tab,start,pivot[1]);
        }
        if (end - 1 > pivot[0]) {
            quickSort(tab, pivot[0], end);
        }
        return;
    }

    public static void quickSort(int[] in) {
        quickSort(in, 0, in.length);
    }

    public int[] sort(int[] in) {
        quickSort(in);
        return in;
    }
}
