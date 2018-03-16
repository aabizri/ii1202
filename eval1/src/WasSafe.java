/*
wasSafe prend trois paramètres: la tableau des températures à comparer, la température maximale et appelle wasSafeR avec le curseur positionné au dernier élément du tableau
wasSafeR prend trois paramètres: la tableau des températures à comparer, la température maximale et la position du curseur dans ce tableau.
wasSafeR vérifie que la température dans le tableau à l'index indiqué par le curseur ne dépasse pas la valeur maximale.
Si la température dépasse, ou que le curseur est à 0, wasSafeR (et donc wasSafe) retourne True, sinon wasSafeR s'appelle avec le curseur décrémenté, et retourne cette valeur.
 */
public class WasSafe {
    public static boolean wasSafe(float[] temps, float tempMax) {
        return wasSafeR(temps, tempMax, temps.length-1);
    }

    public static boolean wasSafeR(float[] temps, float tempMax, int pos) {
        boolean safe = tempMax < temps[pos];
        if(pos==0 || safe){
            return safe;
        }
        return wasSafeR(temps,tempMax,pos-1);
    }

    public static boolean wasSafeI(float[] temps, float tempMax) {
        for (int i = temps.length - 1; i>=0; i--) {
            if (temps[i]>tempMax) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        float [] taba={1.3f,2.2f,5.0f,1.4f,1.4f} ;
        float [] tabb={2.2f,1.3f,3.1f} ;
        boolean ar = wasSafe(taba, 3.1f);
        boolean br = wasSafe(tabb, 10.1f);
        System.out.printf("Récursif:\na : %b\nb : %b\n",ar,br);
        boolean ai = wasSafe(taba, 3.1f);
        boolean bi = wasSafe(tabb, 10.1f);
        System.out.printf("Itératif:\na : %b\nb : %b\n",ai,bi);
    }
}
