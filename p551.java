import java.util.Scanner;

public class p551 {

    public static String getWord(String str, int i, int many, StringBuilder res) {
        if (i < 0) return res.reverse().toString();
        char c = ((char)Integer.parseInt(str.substring(i - many + 1, i + 1)));
        if (Character.isAlphabetic(c) || c == '.' || c == ' ' || c == ',') {
            return getWord(str, i - many, 2, res.append(c));
        }
        return getWord(str, i, many + 1, res);
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        String res, word;

        while (s.hasNext()) {
            word = s.next();
            res = getWord(word, word.length() - 1, 2, new StringBuilder());
            System.out.println( res );
        }

    }

}
