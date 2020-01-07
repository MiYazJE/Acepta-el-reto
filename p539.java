import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p539 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            int n1 = s.nextInt();
            int n2 = s.nextInt();
            System.out.println( ((n2 - n1) % 10 == 9) ? "FELIZ DECADA NUEVA" : "TOCA ESPERAR" );
        }

    }

}
