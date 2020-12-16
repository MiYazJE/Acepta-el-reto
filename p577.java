import java.util.Scanner;

public class p577 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int a, b, c;

        while (n-- != 0) {
            a = s.nextInt();
            b = s.nextInt();
            c = s.nextInt();
            System.out.println( Math.min(c - a + 1, b + 1) );
        }

    }

}
