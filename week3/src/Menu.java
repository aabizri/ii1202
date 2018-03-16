import java.util.Scanner;

public class Menu {
    static Command[] commands = {new Power(), new Dichotomy(), new Syracuse(), new Table(), new Factorial()};

    public static void main(String[] args) {
        for (int i = 0; i<commands.length; i++) {
            System.out.printf("Commande %d: %s\n",i,commands[i].name());
        }

        // On crée un scanner lisant depuis stdin
        Scanner scan = new Scanner(System.in);

        // On demande à l'usager d'entrer la valeur
        System.out.print("Commande à executer : ");

        // On vérifie si elle est valide (peut être interpretée comme un entier)
        // Cela enmpêche un crash pas très gracieux si elle ne l'est pas
        if (!scan.hasNextInt()) {
            System.out.println("La valeur entrée est invalide");
            return;
        }

        // On récupère la valeur
        int choice = scan.nextInt();

        // On ferme le scanner
        scan.close();

        // On appelle la commande
        commands[choice].command(args);
    }
}
