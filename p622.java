import java.util.Scanner;

public class p622 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int sum, n, nota, posible;

        while (true) {
            n = s.nextInt();
            if (n == 0) break;

            sum = 0;
            for (int i = 0; i < n; i++) sum += s.nextInt();

            nota = s.nextInt();
            posible = nota * (n + 1);

            if (sum > posible ||((sum + 10) < posible)) {
                System.out.println("IMPOSIBLE");
            }
            else {
                System.out.println(posible - sum);
            }
        }

    }

}
