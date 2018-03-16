import java.util.Scanner;

public class Ruler {

    public static void printRuler(int length, int interval) {
        // On construit la sortie
        StringBuilder builder = new StringBuilder();

        // On boucle de 0 à length
        // <= et non pas < car ça commence à 0
        for (int i = 0; i<=length; i++) {
            if (i%interval == 0) {
                builder.append("|");
            } else {
                builder.append("-");
            }
        }

        // On extrait le string
        String out = builder.toString();

        // On l'affiche
        System.out.println(out);
    }

    public static void main(String[] args) {
        // On crée un scanner lisant depuis stdin
        Scanner scan = new Scanner(System.in);

        // On demande à l'usager d'entrer la valeur
        System.out.print("Longueur ? ");

        // On vérifie si elle est valide (peut être interpretée comme un entier)
        // Cela enmpêche un crash pas très gracieux si elle ne l'est pas
        if (!scan.hasNextInt()) {
            System.out.println("La valeur entrée est invalide");
            return;
        }

        // On récupère la valeur
        int length = scan.nextInt();

        // On demande à l'usager d'entrer la valeur
        System.out.print("Intervalle ? ");

        // On vérifie si elle est valide (peut être interpretée comme un entier)
        // Cela enmpêche un crash pas très gracieux si elle ne l'est pas
        if (!scan.hasNextInt()) {
            System.out.println("La valeur entrée est invalide");
            return;
        }

        // On récupère la valeur
        int interval = scan.nextInt();

        // On affiche la ruler
        printRuler(length,interval);
    }
}
