import java.util.Scanner;

public class Pave {

    public static void main(String[] args) {
        // On crée un scanner lisant depuis stdin
        Scanner scan = new Scanner(System.in);

        // On itère sur le processus de demande d'entrée pour la longueur, la largeur, l'épaisseur
        // Pour cela, on crée des arrays pour tenir les titres à demander, et les valeurs
        // titles contiendra les titres
        String[] titles = {"longueur","largeur","épaisseur"};
        // values contiendra les valeurs, cela sera peuplé dans la boucle
        double[] values = new double[titles.length];
        // On boucle sur la taille de la première array, rendant le code extensible
        for (int i = 0; i < titles.length; i++) {
            // On demande à l'usager d'entrer la valeur
            System.out.printf("Veillez entrer la valeur coresspondante à %s: ",titles[i]);

            // On vérifie si elle est valide (peut être interpretée comme un flottant)
            // Cela enmpêche un crash pas très gracieux si elle ne l'est pas
            if (!scan.hasNextDouble()) {
                System.out.println("La valeur entrée est invalide");
                return;
            }

            // On récupère la valeur
            double val = scan.nextDouble();

            // On vérifie qu'elle n'est pas négative (qu'est-ce qu'une longueur invalide ?)
            if (val < 0) {
                System.out.println("La valeur ne peut pas être négative");
                return;
            }

            // On applique
            values[i] = val;
        }

        // On calcule le volumne
        double volume = values[0]*values[1]*values[2];

        // Et on affiche à l'usager
        System.out.printf("The volumne is : %f\n",volume);
    }
}
