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

    public static void main(String[] args) {
        System.out.printf("GCD(%d,%d)=%d\n",15,25,gcd(15,25)); // Plus Petit / Plus Grand
        System.out.printf("GCD(%d,%d)=%d\n",25,15,gcd(25,15)); // Plus Grand / Plus Petit
        System.out.printf("GCD(%d,%d)=%d\n",11,17,gcd(11,17)); // 2 nombres relativement premiers
        System.out.printf("GCD(%d,%d)=%d\n",4,4,gcd(4,4)); // 2 fois le même nombre
    }
}
