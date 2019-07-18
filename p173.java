import java.util.*;

/**
 * @author Rubén Saiz
 * 18/07/2019
 */

public class p173 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        char[] puntos;
        int pA, pB;
        char saca;
        boolean espacio, imprimir;

        while (true) {

            puntos = s.next().toCharArray();

            if (puntos[0] == 'F') break;

            saca = 'A';
            pA = 0; pB = 0;
            espacio = false;
            imprimir = true;

            for (int i = 0; i < puntos.length; i++) {
                if (puntos[i] == 'F' && imprimir) {
                    if (espacio) System.out.print(" ");
                    System.out.print(pA + "-" + pB);
                    break;
                } else imprimir = true;

                if (puntos[i] == 'A') {
                    if (saca == 'A') pA++;
                    else saca = 'A';
                }
                else {
                    if (saca == 'B') pB++;
                    else saca = 'B';
                }

                if ((pA > 8 || pB > 8) && (Math.abs(pA - pB) > 1) ) {
                        if (espacio) System.out.print(" ");
                        System.out.print(pA + "-" + pB);
                        pA = pB = 0;
                        espacio = true; imprimir = false;
                }
            }

            System.out.println();
        }

    }

}
