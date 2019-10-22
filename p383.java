import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p383 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        int paginas, mayorDiferencia, max, n1, n2;

        while (casos-- != 0) {
            paginas = s.nextInt();
            mayorDiferencia = Integer.MIN_VALUE;
            n1 = s.nextInt();
            max = n1;
            for (int i = 0; i < paginas - 1; i++) {
                n2 = s.nextInt();
                mayorDiferencia = Math.max(mayorDiferencia, max - n2);
                n1 = n2;
                max = Math.max(max, n1);
            }
            System.out.println( mayorDiferencia );
        }

    }


}
