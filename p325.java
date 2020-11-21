import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class p325 {

    static LinkedList<String> permutations = new LinkedList<>();
    static HashSet<String> memo = new HashSet<>();

    static void permute(String str, String g) {
        if (memo.contains(g)) return;
        memo.add(g);
        if (str.isEmpty()) {
            permutations.add(g);
        }
        else {
            for (int i = 0; i < str.length(); i++) {
                permute(str.substring(0, i) + str.substring(i + 1), g + str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String str;
        int C = s.nextInt();

        while (C-- != 0) {
            str = "";
            for (int i = s.nextInt(); i > 0; i--) str = str.concat("C");
            for (int i = s.nextInt(); i > 0; i--) str = str.concat("V");
            permute(str, "");
            for (int i = 0; i < permutations.size(); i++) {
                System.out.print(permutations.get(i));
                if (i < permutations.size() - 1) System.out.print(" ");
                else System.out.println();
            }
            permutations.clear();
            memo.clear();
        }

    }

}
