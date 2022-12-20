import java.util.Scanner;

public class p657 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int A, B, C;
        int c = s.nextInt();

        while (c-- != 0) {
            A = s.nextInt();
            B = s.nextInt();
            C = s.nextInt();

            int distA = Math.abs(A - B);
            int distB = Math.abs(C - B);

            if (A < 0 && B > 0) distA--;
            if (B < 0 && C > 0) distB--;

            if (distA == distB) {
                System.out.println("EMPATE");
            }
            else if (distA < distB) {
                System.out.println(A);
            }
            else {
                System.out.println(C);
            }
        }

    }

}
