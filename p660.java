import java.util.HashSet;
import java.util.Scanner;

public class p660 {

    static boolean isVocal(char c) {
        return c == 'a' || c == 'e' ||
               c == 'i' || c == 'o' ||
               c == 'u';
    }

    static void getPartsOfWord(char[] str, HashSet<String> parts) {

        for (int i = 0; i < str.length;) {
            if ((i == 0 && isVocal(str[i]))) {
                parts.add(str[i] + "");
                i++;
                continue;
            }

            if ((i + 3) == str.length) {
                parts.add(str[i] + "" + str[i + 1] + "" + str[i + 2]);
                return;
            }

            if ((i + 2) == str.length) {
                parts.add(str[i] + "" + str[i + 1]);
                return;
            }

            if (!isVocal(str[i + 3])) {
                parts.add(str[i] + "" + str[i + 1] + "" + str[i + 2]);
                i += 3;
                continue;
            }

            parts.add(str[i] + "" + str[i + 1]);
            i += 2;
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        HashSet<String> parts = new HashSet<String>();

        int N = s.nextInt();
        s.nextLine();

        while (N-- != 0) {
            String line = s.nextLine().toLowerCase();

            for (String str : line.split(" ")) {
                getPartsOfWord(str.toCharArray(), parts);
            }

            System.out.println( parts.size() );
            parts.clear();
        }

    }

}
