import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p260 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos = s.nextInt(); s.nextLine();
        String str1, str2;

        for (int c = 0; c < casos; c++) {

            str1 = s.nextLine().replace(" ", "").toLowerCase();
            str2 = s.nextLine().replace(" ", "").toLowerCase();

            if (str1.length() != str2.length()) System.out.println("NO");
            else {

                boolean anagram = true;
                int[] table = new int[58];

                for (char letra : str1.toCharArray()) table[letra - 'A']++;

                for (char letra : str2.toCharArray()) {
                    table[letra - 'A']--;
                    if (table[letra - 'A'] < 0) anagram = false;
                }

                System.out.println( anagram ? "SI" : "NO" );
            }

        }

    }

}
