import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p345 {

    public static boolean comprobarFila(int[][] m, int f) {
        int[] test = new int[9];
        for (int c = 0; c < m.length; c++) {
            if (test[m[f][c]-1] == 1) return false;
            test[m[f][c]-1] = 1;
        }
        return true;
    }

    public static boolean comprobarColumna(int[][] m, int c) {
        int[] test = new int[9];
        for (int f = 0; f < m.length; f++) {
            if (test[m[f][c]-1] == 1) return false;
            test[m[f][c]-1] = 1;
        }
        return true;
    }

    public static boolean comprobarRegion(int[][] m) {
        int max, x, y;
        int[] valores = {0, 3, 6, 0, 3, 6, 0, 3, 6};
        for (int l = 0; l < 9; l++) {
            x = y = valores[l];
            max = x + 3;
            int[] test = new int[9];
            for (int i = x; i < max; i++) {
                for (int j = y; j < max; j++) {
                    if (test[m[i][j]-1] == 1) return false;
                    test[m[i][j]-1] = 1;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        /**
         * 1.- Comprobar filas
         * 2.- Comprobar columnas
         * 3.- Comprobar apartados
         */

        int casos = s.nextInt();
        int[][] sudoku;
        boolean valido;

        for (int l = 0; l < casos; l++) {

            sudoku = new int[9][9];
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    sudoku[i][j] = s.nextInt();

            // COMPROBAR FILAS COLUMNAS
            valido = true;
            for (int i = 0; i < 9; i++) {
                if (!comprobarFila(sudoku, i)) valido = false;
                if (valido && !comprobarColumna(sudoku, i)) valido = false;
                if (!valido) break;
            }

            if (valido)
                valido = comprobarRegion(sudoku);

            System.out.println( (valido) ? "SI" : "NO");
        }

    }

}
