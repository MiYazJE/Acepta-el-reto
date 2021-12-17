import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p619 {

    static boolean isValid(Character[][] m, int startF, int startC, int endF, int endC) {
        Set<Character> set = new HashSet<>();
        for (int i = startF; i < endF; i++) {
            for (int j = startC; j < endC; j++) {
                if (set.size() > 2) return false;
                set.add(m[i][j]);
            }
        }
        return set.size() < 3;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int f, c;
        Character[][] m;
        boolean valid;

        while (true) {
            c = s.nextInt();
            f = s.nextInt();
            s.nextLine();
            if (c == 0 && f == 0) break;
            if ((c % 8 != 0) || (f % 8 != 0)) {
                System.out.println("NO");
                continue;
            }

            m = new Character[f][c];
            valid = true;

            for (int i = 0; i < f; i++) {
                String input = s.nextLine();
                for (int j = 0; j < c; j++) {
                    m[i][j] = input.charAt(j);
                }
            }

            for (int i = 0; i < f && valid; i+=8)
                for (int j = 0; j < c && valid; j+=8)
                    valid = isValid(m, i, j, i + 8, j + 8);

            System.out.println(valid ? "SI" : "NO");
        }
    }

}
