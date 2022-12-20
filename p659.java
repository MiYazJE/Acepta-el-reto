import java.util.Scanner;

public class p659 {

    static String getRepeat(String c, int times) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < times; i++) str.append(c);

        return str.toString();
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n;
        StringBuilder res = new StringBuilder();

        while (true) {
            n = s.nextInt();
            if (n == 0) break;

            if (n / 1_000_000 > 0) {
                res.append(getRepeat("H", n / 1_000_000));
                n %= 1_000_000;
            }
            if (n / 100_000 > 0) {
                res.append(getRepeat("R", n / 100_000));
                n %= 100_000;
            }
            if (n / 10_000 > 0) {
                res.append(getRepeat("D", n / 10_000));
                n %= 10_000;
            }
            if (n / 1_000 > 0) {
                res.append(getRepeat("F", n / 1_000));
                n %= 1_000;
            }
            if (n / 100 > 0) {
                res.append(getRepeat("C", n / 100));
                n %= 100;
            }
            if (n / 10 > 0) {
                res.append(getRepeat("G", n / 10));
                n %= 10;
            }
            if (n > 0) {
                res.append(getRepeat("T", n));
            }


            System.out.println( res );

            res.delete(0, res.length());
        }

    }

}
