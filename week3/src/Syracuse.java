public class Syracuse implements Command{
    // Calcule syracuse pour un n donné, en allant de Haut (Sn) en Bas (S0)
    public static int syracuse(int N, int index) {
        if (index == 0) {
            return N;
        }

        if ((index-1)%2 == 0) {
            return syracuse(N, index-1)/2;
        } else {
            return 3*syracuse(N,index-1)+1;
        }
    }

    // Calcul de la suite de syracuse du bas (S0 = N) vers le haut
    public static int syracuseUp(int previousIndex, int previousValue) {
        System.out.printf("Previous Index: %d, Previous Value: %d\n",previousIndex,previousValue);
        // If previous value is 1, return index
        if (previousValue == 1) {
            return previousIndex;
        }

        // New values
        int newIndex = previousIndex+1;
        int newValue;

        // Calculate Sn
        if (previousValue%2 == 0) {
           newValue = previousValue/2;
        } else {
            newValue = 3*previousValue+1;
        }

        // Continue
        return syracuseUp(newIndex, newValue);
    }

    public static void main(String[] args) {
        System.out.println(syracuse(5, 2));
        System.out.println(syracuseUp(0,5));
    }

    public void command(String[] args) {
        main(args);
    }

    public String name() {
        return "Syracuse";
    }
}
