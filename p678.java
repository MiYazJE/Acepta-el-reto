import java.util.HashSet;
import java.util.Scanner;

public class p678 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String hidden;

        while (true) {
            hidden = s.next();
            if (hidden.equals(".")) return;

            System.out.println(solve(hidden, s.next()));
        }
    }

    static String solve(String hidden, String expected) {
        int fails = 0;
        HashSet<Character> word = new HashSet<>();
        HashSet<Character> already = new HashSet<>();
        for (char c : hidden.toCharArray()) word.add(c);

        for (char c : expected.toCharArray()) {
            if (already.contains(c)) continue;
            if (!word.contains(c)) fails++;
            else word.remove(c);
            if (word.isEmpty()) return "SALVADO";
            if (fails == 7) return "AHORCADO";
            already.add(c);
        }

        return "COLGANDO";
    }

}
