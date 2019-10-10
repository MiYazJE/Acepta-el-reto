import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p428 {

    static String parse(long num, StringBuilder base5) {
        if (num == 0) return base5.reverse().toString();
        return parse(num / 5, base5.append(num % 5));
    }

    public static void main(String[] args) throws IOException {

        final BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

        int casos = Integer.parseInt(s.readLine());
        long num, n;
        boolean uno, dos;

        while (casos-- != 0) {
            num = Integer.parseInt(s.readLine());
            uno = dos = false;
            num = Long.parseLong(parse(num, new StringBuilder()));
            while (num > 0) {
                n = num % 10;
                num /= 10;
                if (n == 4 && uno) dos = true;
                if (n == 4) uno = true;
            }
            System.out.println( (dos) ? "SI" : "NO" );
        }

    }

}
