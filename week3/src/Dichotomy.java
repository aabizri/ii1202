public class Dichotomy implements Command{
    public static int dichotomy(int[] orderedArray, int start, int end, int target) {
        // Calculate length
        int length = end - start;

        // If length is one, we're done searching
        if (length == 1) {
            return orderedArray[start] == target ? start : -1;
        }

        // Calculate pivot
        int pivotPos = start + length / 2;
        int pivotVal = orderedArray[pivotPos];

        // If target matches pivot's value, return pivot's position
        if (target == pivotVal) {
            return pivotPos;
        }

        // Redefine start or end parameters
        if (target < pivotVal) {
            end = pivotPos;
        } else if (target > pivotVal) {
            start = pivotPos;
        }

        // Recurse
        return dichotomy(orderedArray, start, end, target);
    }

    public static void main(String[] args) {
        int[] table = {1, 3, 7, 12, 13};
        int res = dichotomy(table, 0, table.length, 12);
        System.out.println(res);
    }

    public void command(String[] args) {
        main(args);
    }

    public String name() {
        return "Dichotomy";
    }
}
