import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p538 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        while (true) {
            int n1 = s.nextInt();
            int n2 = s.nextInt();
            if (n1 == 0 && n2 == 0) break;
            System.out.println( (n1 < n2) ? "SENIL" : "CUERDO" );
        }

    }

}
