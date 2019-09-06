import java.util.*;

public class p266 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        char[][] m;
        int f, c;
        char replace1, replace2;
        String input;
        TreeMap<Character, Character> map = new TreeMap<>();

        while (true) {

            f = s.nextInt();
            c = s.nextInt();

            if (f == 0 && c == 0) break;
            m = new char[f][c];

            for (int i = 0; i < f; i++) {
                input = s.next();
                for (int j = 0; j < c; j++) {
                    m[i][j] = input.charAt(j);
                    map.put(m[i][j], m[i][j]);
                }
            }

            for (int i = s.nextInt(); i > 0; i--) {
                replace1 = s.next().charAt(0);
                replace2 = s.next().charAt(0);
                for (Map.Entry<Character, Character> entry : map.entrySet()) {
                    if (entry.getValue() == replace1) {
                        map.put(entry.getKey(), replace2);
                    }
                }
            }

            for (int i = 0; i < f; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(map.get(m[i][j]));
                }
                System.out.println();
            }

            map.clear();
        }

    }

}
