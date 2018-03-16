// 3.2.1
public class GCD {
    public static int gcd(int a, int b) {
        // Condition d'inversion de a et b si b <= a
        if (a < b) {
            gcd(b,a);
        }

        // Condition d'arrêt
        if (b == 0) {
            return a;
        }

        // Appel récursif
        return gcd(b,a%b);
    }
}
