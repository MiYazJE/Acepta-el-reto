import java.util.Scanner;

public class p644 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            int Y = s.nextInt();
            if (Y == 0) break;

            int a = Y % 19;
            int b = Y % 4;
            int c = Y % 7;

            int P = Y / 100;
            int Q = ((13 + 8 * P) / 25);
            int M = (15 - Q + P - (P / 4)) % 30;
            int N = (4 + P - (P / 4)) % 7;

            int d = (19 * a + M) % 30;
            int e = ((2 * b) + (4 * c) + (6 * d) + N) % 7;

            if ((d + e) < 10) {
                int day = (d + e) + 22;
                System.out.println(((int) day) + " de marzo");
            }
            else {
                int day = (d + e) - 9;
                if (day == 26) day = 19;
                if (day == 25 && d == 28) day = 18;
                System.out.println(((int) day) + " de abril");
            }
        }

    }

}
