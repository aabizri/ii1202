import java.util.Scanner;

public class Equation {
    public static void main(String[] args) {
        // On crée un scanner lisant depuis stdin
        Scanner scan = new Scanner(System.in);

        // On itère sur le processus de demande d'entrée pour la longueur, la largeur, l'épaisseur
        // Pour cela, on crée des arrays pour tenir les titres à demander, et les valeurs
        // titles contiendra les titres
        String[] titles = {"a","b","c"};
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

            // On enregistre
            values[i] = val;
        }

        // On enlève les valeurs de la boucle
        double a = values[0];
        double b = values[1];
        double c = values[2];

        // On calcule le discriminant
        double delta = (Math.pow(a, 2)) - (4 * a * c);

        // On switch dessus
        String out = "";
        if (delta == 0) {
            double res = -b / (2 * a);
            out = "Le résultat est : " + String.valueOf(res);
        } else if (delta > 0) {
            double res1 = (-b - Math.sqrt(delta)) / (2 * a);
            double res2 = (-b + Math.sqrt(delta)) / (2 * a);
            out = "Les deux solutions sont :\nx1: " + res1 + "\nx2: " + res2;
        } else {
            out = "Il n'y a pas de solutions réelles";
        }

        // Print it out
        System.out.println(out);
    }
}