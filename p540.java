import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p540 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int casos = s.nextInt();

        while (casos-- != 0) {
            int pisos = s.nextInt();
            int escalonesPiso = s.nextInt();
            int pisosBajados = s.nextInt();
            int extra = s.nextInt();
            int bajada = pisosBajados * escalonesPiso + extra;
            int subida = bajada + (pisos * escalonesPiso);
            System.out.println( bajada + " " + subida );
        }

    }


}
