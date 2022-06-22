import java.util.Scanner;

public class p638 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int cases = s.nextInt();

        while (cases-- != 0) {
            int n = s.nextInt();
            int a = s.nextInt();
            if (a % (n - 1) == 0) {
                System.out.printf("%d %d\n", a + (a / (n - 1)) - 1,  a + (a / (n - 1)));
            }
            else {
                System.out.printf("%d %d\n", a + (a / (n - 1)), a + (a / (n - 1)));
            }
        }

    }

}
