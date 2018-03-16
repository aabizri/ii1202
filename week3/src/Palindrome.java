public class Palindrome implements Command{
    public static boolean isPalindrome(String word) {
        String[] splitted = word.split("");
        for (int i = 0; i < splitted.length; i++) {
            // Si on est au milieu, break
            if (i == splitted.length - 1 - i) {
                break;
            }

            // Si on a une différence, on répond négativement
            if (!splitted[i].equals(
                    splitted[splitted.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeR(String word, int cur) {
        // Si on est au milieu dans un mot impair, ou après le milieu dans tout type de mot, return true
        // La troncature dans la division des entiers permet une telle condition
        if ((word.length()%2 != 0 && cur == word.length()/2 + 1)
            || cur > word.length()/2) {
            return true;
        }

        // Comparer les charactères
        char a = word.charAt(cur);
        char b = word.charAt(word.length()-1-cur);
        if (a != b) {
            return false;
        }

        return isPalindromeR(word,++cur);

    }

    public static void main(String[] args) {
        System.out.println("Mode non-récursif: ");
        System.out.printf("patate : %b\n",isPalindrome("patate"));
        System.out.printf("kayak : %b\n",isPalindrome("kayak"));
        System.out.printf("elle : %b\n",isPalindrome("elle"));

        System.out.println("Mode récursif: ");
        System.out.printf("patate : %b\n",isPalindromeR("patate",0));
        System.out.printf("kayak : %b\n",isPalindromeR("kayak",0));
        System.out.printf("elle : %b\n",isPalindromeR("elle",0));
    }

    public void command(String[] args) {
        main(args);
    }

    public String name() {
        return "Palindrome";
    }
}
