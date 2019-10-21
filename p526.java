import java.util.*;

public class p526 {

    static ArrayList<String> aux = new ArrayList<>(Arrays.asList(
            "h", "li", "na", "k", "rb", "cs", "fr",
            "be", "mg", "ca", "sr", "ba", "ra",
            "sc", "y",
            "ti", "zr", "hf", "rf",
            "v", "nb", "ta", "db",
            "cr", "mo", "w", "sg",
            "mn", "tc", "re", "bh",
            "fe", "ru", "os", "hs",
            "co", "rh", "ir", "mt",
            "ni", "pd", "pt", "ds",
            "cu", "ag", "au", "rg",
            "zn", "cd", "hg", "cn",
            "b", "al", "ga", "in", "tl", "nh",
            "c", "si", "ge", "sn", "pb", "fl",
            "n", "p", "as", "sb", "bi", "mc",
            "o", "s", "se", "te", "po", "lv",
            "f", "cl", "br", "i", "at", "ts",
            "he", "ne", "ar", "kr", "xe", "rn", "og",
            "la", "ce", "pr", "nd", "pm", "sm", "eu", "gd", "tb", "dy", "ho", "er", "tm", "yb", "lu",
            "ac", "th", "pa", "u", "np", "pu", "am", "cm", "bk", "cf", "es", "fm", "md", "no", "lr"
    ));

    static HashSet<String> tabla;
    static HashMap<Integer, Boolean> dp = new HashMap<>();

    static boolean isPosible(String s, int start, int max) {
        if (start == s.length()) {
            return true;
        }

        if (dp.containsKey(start)) {
            return dp.get(start);
        }

        for (int i = start; i < start + max && i < s.length(); i++) {
            String newWord = s.substring(start, i + 1);
            if (!tabla.contains(newWord)) {
                continue;
            }
            if (isPosible(s, i + 1, max)) {
                dp.put(start, true);
                return true;
            }
        }

        dp.put(start, false);

        return false;
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        tabla = new HashSet<>(aux);
        String word;

        while (s.hasNext()) {
            word = s.nextLine().replace(" ", "").toLowerCase();
            System.out.println( isPosible(word, 0, 2) ? "SI" : "NO" );
            dp.clear();
        }
    }

}
