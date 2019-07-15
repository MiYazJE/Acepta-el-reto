import java.util.Scanner;

/**
 * @author Ruben Saiz
 */

public class p284 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        final int DOS_EUROS       = 0;
        final int UN_EURO         = 1;
        final int CINCUENTA_CENTS = 2;
        final int VEINTE_CENTS    = 3;
        final int DIEZ_CENTS      = 4;
        final int CINCO_CENTS     = 5;
        final int DOS_CENTS       = 6;
        final int UN_CENT         = 7;

        int total, entregado, devolver;
        int[] monedas;
        int casos = s.nextInt();

        for (int i = 0; i < casos; i++) {

            total     = s.nextInt();
            entregado = s.nextInt();

            monedas = new int[8];


            if (total > entregado) {
                System.out.println("DEBE " + (total - entregado));
            }
            else {

                devolver = entregado - total;
                while (devolver > 0) {

                    if (devolver >= 200) {
                        devolver -= 200;
                        monedas[DOS_EUROS]++;
                    }
                    else if (devolver >= 100) {
                        devolver -= 100;
                        monedas[UN_EURO]++;
                    }
                    else if (devolver >= 50) {
                        devolver -= 50;
                        monedas[CINCUENTA_CENTS]++;
                    }
                    else if (devolver >= 20) {
                        devolver -= 20;
                        monedas[VEINTE_CENTS]++;
                    }
                    else if (devolver >= 10) {
                        devolver -= 10;
                        monedas[DIEZ_CENTS]++;
                    }
                    else if (devolver >= 5) {
                        devolver -= 5;
                        monedas[CINCO_CENTS]++;
                    }
                    else if (devolver >= 2) {
                        devolver -= 2;
                        monedas[DOS_CENTS]++;
                    }
                    else if (devolver >= 1) {
                        devolver -= 1;
                        monedas[UN_CENT]++;
                    }

                }

                for (int j = 0; j < 8; j++) {
                    System.out.print(monedas[j]);
                    if (j < 7) System.out.print(" ");
                }

                System.out.println("");
            }

        }

    }

}
