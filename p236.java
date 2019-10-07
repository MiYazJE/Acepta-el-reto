import java.util.Scanner;

public class p236 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        long res, g, m, c;

        while (true) {
            g = s.nextLong();
            m = s.nextLong();
            c = s.nextLong();
            if (g == 0 && m == 0 && c == 0) break;
            res = 0;
            for (int i = 0; i < c; i++) {
                res += g;
                g *= m;
            }
            System.out.println( res );
        }

    }

}
