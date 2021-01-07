import java.util.Scanner;

public class p584 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n1, n2, n3;
        for (int i = s.nextInt(); i > 0; i--) {
            n1 = s.nextInt();
            n2 = s.nextInt();
            n3 = s.nextInt();
            if ((n1 / n2 == n3) && (n2 * n3 >= n1))
                System.out.println("AMBAS");
            else if (n2 * n3 >= n1)
                System.out.println("HORAS");
            else System.out.println("ENCENDIDOS");
        }
    }

}
