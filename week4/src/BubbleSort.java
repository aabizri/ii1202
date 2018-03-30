public class BubbleSort implements Sort{
    public static int[] bubbleSort(int[] in) {
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in.length-i-1; j++) {
                if (in[j]>in[j+1]) {
                    int tmp = in[j];
                    in[j] = in[j+1];
                    in[j+1] = tmp;
                }
            }
        }
        return in;
    }

    public int[] sort(int[] in) {
        return bubbleSort(in);
    }
}
