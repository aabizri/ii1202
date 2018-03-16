public class CrossSubstraction {
    public static int crossSubstraction(int[][] tab) {
        // Si tab n'a pas un nombre de colonnes impair (s'il est pair), erreur (on retourne 0)
        if (tab.length % 2 == 0) {
            return 0;
        }

        // Idem pour les lignes
        for (int i = 0; i<tab.length; i++) {
            if (tab[i].length % 2 == 0) {
                return 0;
            }
        }

        // Identifier la colonne du milieu
        int middleColumnIndex = tab[0].length / 2;

        // Somme des termes de la colonne du milieu
        int middleColumnSum = 0;
        for (int i = 0; i<tab.length; i++) {
            middleColumnSum += tab[i][middleColumnIndex];
        }

        // Identifier la ligne du milieu
        int middleLineIndex = tab.length / 2;

        // Somme des termes de la ligne du milieu
        int middleLineSum = 0;
        for (int i = 0; i<tab[middleLineIndex].length; i++) {
            middleLineSum += tab[middleLineIndex][i];
        }

        return middleLineSum - middleColumnSum;
    }

    public static void main(String[] args) {
        int[][] tab = {
                {2,4,6},
                {9,10,17},
                {1,6,18},
        };

        System.out.printf("%d", crossSubstraction(tab));
    }
}
