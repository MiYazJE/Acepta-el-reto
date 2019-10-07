import java.util.Scanner;

public class p350 {

    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        float l1, l2;
        while (true) {
            l1 = s.nextFloat();
            l2 = s.nextFloat();
            if (l1 == 0 && l2 == 0) break;
            System.out.printf("%.1f\n", ((l1 * l2) / 2));
        }

    }

}
