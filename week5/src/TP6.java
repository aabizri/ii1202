public class TP6 {
    public static void main(String[] args) throws Exception {
        ListInteger l0 = new ListInteger(15);
        ListInteger l1 = new ListInteger(36);
        ListInteger l2 = new ListInteger(-4);
        ListInteger l3 = new ListInteger(9);
        ListInteger l4 = new ListInteger(13);
        ListInteger l5 = new ListInteger(22);
        ListInteger l6 = new ListInteger(-9);
        ListInteger l7 = new ListInteger(70);

        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        // Print length
        System.out.println(l0.length());

        // Invert twice
        System.out.println(l0);
        l0 = l0.invert();
        System.out.println(l0);
        l0 = l0.invert();
        System.out.println(l0);

        // Permute
        l0.permute(2,5);
        System.out.println(l0);

        // Max value
        System.out.printf("Max Value: %d\n",l0.max().val);

        // Insert
        l0.insert(2,12);
        System.out.println(l0);

        // Remove
        l0.remove(2);
        System.out.println(l0);
    }
}
