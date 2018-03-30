public class PrintTab {
    public static void PrintTab(int tab[]) {
        System.out.println(format(tab));
    }

    public static String format(int[] tab) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tab.length; i++) {
            builder.append(tab[i]);
            builder.append(" ");
        }
        return builder.toString();
    }
}
