/*
3.6.1.2 L'éxécution de la fonction est lente avec i grand, car la valeur de Fi-2 n'est pas sauvegardée lors du calcul,
ce qui fait qu'elle est recalculée en tant que Fi-1 à l'appel suivant.

3.6.1.3 La complexité de la version naïve est exponentielle, c'est même O(phi^(n+1)), phi étant le nombre d'or
*/
public class Fibonacci {
    public static int Fib1(int i) {
        // Conditions d'arrêt (valeurs F0,F1)
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }

        // Appel à la récursive
        return Fib1(i-1)+Fib1(i-2);
    }

    public static int Fib2(int i) {
        // Print
        System.out.printf("Fib(%d)\n",i);

        // Conditions d'arrêt (valeurs F0,F1)
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }

        // Appel à la récursive
        return Fib2(i-1)+Fib2(i-2);
    }

    static long[] memory;

    public static long FibMem(int i) {
        memory = new long[i+1];
        memory[1] = 1;
        return FibMemR(i);
    }

    public static long FibMemR(int i) {
        // Vérifier dans la mémoire
        if (memory[i] != 0) {
            return memory[i];
        } else if (i == 0) {
            return 0;
        }

        // Appel à la récursive
        long val = FibMemR(i-1) + FibMemR(i-2);

        // Enregistrer la valeur
        memory[i] = val;

        return val;
    }

    public static void main(String[] args) {
        System.out.printf("Récursif Naïf : Fib(%d) = %d\n", 20, Fib1(6));
        System.out.printf("Récursif avec Mémoire : Fib(%d) = %d\n", 120, FibMem(120));
    }
}
