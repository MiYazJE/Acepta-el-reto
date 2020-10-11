import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p300 {

    static boolean isPentaVowel(String w) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (Character c : w.toCharArray()) vowels.remove(c);
        return vowels.isEmpty();
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int C = s.nextInt();

        while (C-- != 0)
            System.out.println( isPentaVowel(s.next()) ? "SI" : "NO" );

    }

}
