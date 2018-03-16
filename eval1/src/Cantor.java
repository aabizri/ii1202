public class Cantor {
    public static int cantor(int a, int b) {
        return cantorR(a,b,0,0,0);
    }

    public static int cantorR(int x, int y, int curX, int curY, int val) {
        // Valeur
        val++;

        // Si on est sur l'ordonnée, on passe à x = y + 1, y = 0
        if (curX == 0) {
            curX = curY + 1;
            curY = 0;
        } else { // Autrement on passe à x = x-1, y = y+1
            curX = curX - 1;
            curY = curY + 1;
        }

        // Condition d'arrêt
        if (curX == x && curY == y) {
            return val;
        }

        // Go
        return cantorR(x,y,curX,curY,val);
    }

    public static int cantorIterative(int a, int b) {
        return (a+b)*(a+b+1)/2+b;
    }

    public static void main(String[] args) {
        System.out.printf("Recursive Cantor: %d\n",cantor(3,1));
        System.out.printf("Iterative Cantor : %d\n", cantorIterative(3,1));
    }
}
