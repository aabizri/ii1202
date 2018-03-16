
/*
3.1
3.1.1 La fonction présentée ici (3.1.1) calcule la factorielle de `n` en itérant de 2 à n et en multipliant chaque valeur avec le résultat de étape précédente.
Mathématiquement, n! = n*(n-1)*(n-2)* ... * 2
 */
public class Factorial {
    public static int factorial(int a) {
        if (a == 0) {
            return 1;
        }

        return a*factorial(a-1);
    }
}
