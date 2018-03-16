import java.util.Scanner;

public class Power {
    public static int power(int base, int exponent) {
        // Cas spécial où n = 0
        if (exponent == 0) {
            return 1;
        }

        // Bouclons
        int res = base;

        // On commence à 1
        for (int i = 1; i<exponent; i++) {
            res = res*base;
        }

        // Terminé
        return res;
    }

    public static void main(String[] args) {
        // On crée un scanner lisant depuis stdin
        Scanner scan = new Scanner(System.in);

        // On demande à l'usager d'entrer la valeur
        System.out.print("Base ? ");

        // On vérifie si elle est valide (peut être interpretée comme un entier)
        // Cela enmpêche un crash pas très gracieux si elle ne l'est pas
        if (!scan.hasNextInt()) {
            System.out.println("La valeur entrée est invalide");
            return;
        }

        // On récupère la valeur
        int base = scan.nextInt();

        // On demande à l'usager d'entrer la valeur
        System.out.print("Exposant ? ");

        // On vérifie si elle est valide (peut être interpretée comme un entier)
        // Cela enmpêche un crash pas très gracieux si elle ne l'est pas
        if (!scan.hasNextInt()) {
            System.out.println("La valeur entrée est invalide");
            return;
        }

        // On récupère la valeur
        int exponent = scan.nextInt();

        // On affiche la ruler
        int result = power(base,exponent);
        System.out.printf("Résultat: %d\n",result);
    }
}
