import java.util.Scanner;

/**
 * Problema 176-Campo de minas
 * @author retos_killer
 */

public class p176 {

    public static int buscarMinas(char[][] m, int i, int j) {
        int[] posF = {1, -1, 0, 0, 1, -1, -1, 1};
        int[] posC = {0, 0, 1, -1, 1, -1, 1, -1};
        int f, c, minas = 0;
        for (int k = 0; k < 8; k++) {
            f = i + posF[k];
            c = j + posC[k];
            if (safe(f, c) && m[f][c] == '*') {
                minas++;
            }
        }
        return minas;
    }

    public static boolean safe(int i, int j) {
        if (i >= 0 && i < r && j >= 0 && j < c) {
            return true;
        }
        return false;
    }

    public static int r;
    public static int c;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        char[][] m;
        String linea;

        while (true) {

            c = s.nextInt();
            r = s.nextInt();
            if (r == 0 || c == 0) System.exit(0);
            s.nextLine();

            m = new char[r][c];
            for (int i = 0; i < r; i++) {
                linea = s.nextLine();
                for (int j = 0; j < c; j++) {
                    m[i][j] = linea.charAt(j);
                }
            }

            int minas = 0;
            int cantidad;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (m[i][j] == '-') {
                        cantidad = buscarMinas(m, i, j);
                        if (cantidad >= 6) minas++;
                    }
                }
            }

            System.out.println(minas);
        }

    }

}
