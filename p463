import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p463 {

    public static void print(char[][] m, int iF, int fF, int fC) {
        for (int i = iF; i <= fF; i++) {
            for (int j = 0; j <= fC; j++) {
                if (m[i][j] == '\u0000') System.out.print(" ");
                else System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }

    public static void imprimirBien(char[][] m, int iniF, int finF, int finC) {
        for (int i = 0; i < finC+2; i++) System.out.print("#");
        System.out.println();
        for (int i = iniF; i <= finF; i++) {
            System.out.print("#");
            for (int j = 0; j < finC; j++) {
                if (m[i][j] == '\u0000') System.out.print(" ");
                else System.out.print(m[i][j]);
            }
            System.out.println("#");
        }
        for (int i = 0; i < finC+2; i++) System.out.print("#");
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String linea;
        char[][] m;
        int iniF, finF, actual;

        /*

        #############
        #      _____#
        #   /\/     #
        #__/        #
        #############

         */

        while (s.hasNext()) {

            linea = s.nextLine();

            m = new char[200][100];
            iniF = 99;
            finF = 99;
            actual = 99;

            for (int i = 0; i < linea.length(); i++) {
                if (linea.charAt(i) == 'I') {
                    m[actual][i] = '_';
                }
                else if (linea.charAt(i) == 'S') {
                    m[actual][i] = (char) 47;
                    if (i < linea.length() - 1) {
                        if (linea.charAt(i+1) != 'B') actual--;
                    }
                }
                else if (linea.charAt(i) == 'B') {
                    if (i > 0 && linea.charAt(i-1) != 'S') {
                        m[++actual][i] = (char) 92;
                    }
                    else {
                        m[actual][i] = (char) 92;
                    }
                }
                if (actual < iniF) iniF = actual;
                if (actual > finF) finF = actual;
                // print(m, iniF, finF, i);
            }

            imprimirBien(m, iniF, finF, linea.length());
        }

    }

}
