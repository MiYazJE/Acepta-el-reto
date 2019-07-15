import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p356 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        Long[] numeros;

        for (int i = 0; i < casos; i++) {

            numeros = new Long[3];
            for (int j = 0; j < 3; j++) numeros[j] = s.nextLong();
            Arrays.sort( numeros );

            for (int j = 0; j < 3; j++) {
                System.out.print(numeros[j]);
                if (j != 2) System.out.print(" ");
                else System.out.println();
            }

        }

    }

}
