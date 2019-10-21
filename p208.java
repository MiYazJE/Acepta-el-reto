import java.util.Scanner;

public class p208 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        long n1, n2;

        while (true) {
            n1 = s.nextLong();
            n2 = s.nextLong();
            if (n1 == 0 && n2 == 0) break;
            long total = (n1 * (n1 + 1)) / 2;
            long n3 = Math.abs(n1 - n2) + 1;
            long calc = (n3 * (n3 + 1)) / 2;
            System.out.println( (total - calc) );
        }

    }

}
