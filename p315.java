import java.util.*;

public class p315 {

    public static void resuelveCaso(int[][] ref, int i, int j) {
        int[] posF = {1, -1, 0, 0, 1, -1, -1, 1};
        int[] posC = {0, 0, 1, -1, 1, -1, 1, -1};
        int f, c;
        for (int k = 0; k < 8; k++) {
            f = i + posF[k];
            c = j + posC[k];
            if (valido(ref, f, c)) {
                ref[f][c]++;
            }
        }
    }

    public static int buscaminas(int[][] ref, int f, int c) {

        if (valido(ref, f, c) && !aux[f][c]) {
            aux[f][c] = true;
            if (ref[f][c] != 0) { 

            } else {
                return buscaminas(ref, f-1, c)   +  // arriba
                       buscaminas(ref, f-1, c+1) +  // arriba derecha
                       buscaminas(ref, f, c+1)   +  // derecha
                       buscaminas(ref, f+1, c+1) +  // derecha abajo
                       buscaminas(ref, f+1, c)   +  // abajo
                       buscaminas(ref, f+1, c-1) +  // izquierda abajo
                       buscaminas(ref, f, c-1)   +  // izquierda
                       buscaminas(ref, f-1, c-1);   // izquierda arriba
            }
        }

        return 0;
    }

    public static boolean valido(int[][] m, int f, int c) {
        if ((f >= 0 && f < m.length) && (c >= 0 && c < m[0].length))
            return true;

        return false;
    }

    public static void imprimirFinal(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (aux[i][j] && m[i][j] != 0) System.out.print(m[i][j]);
                else if (aux[i][j] && m[i][j] == 0) System.out.print("-");
                else System.out.print("X");
            }
            System.out.println("");
        }
    }

    public static boolean[][] aux;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int f, c, casos, fBuscar, cBuscar;
        int[][] ref, prin;
        String linea;
        boolean gameOver;

        while (s.hasNext()) {

            f = s.nextInt();
            c = s.nextInt();

            ref = new int[f][c];
            aux = new boolean[f][c];
            prin = new int[f][c];
            
            for (int i = 0; i < f; i++) {
                linea = s.next();
                for (int j = 0; j < c; j++) {
                    if (linea.charAt(j) == '*') {
                        prin[i][j] = 1;
                        resuelveCaso(ref, i, j);
                    }
                }
            }

            casos = s.nextInt();
            gameOver = false;

            for (int i = 0; i < casos; i++) {

                fBuscar = s.nextInt();
                cBuscar = s.nextInt();
                fBuscar--; cBuscar--;

                if (prin[fBuscar][cBuscar] == 1) {
                    gameOver = true;
                }

                if (!gameOver) {
                    buscaminas(ref, fBuscar, cBuscar);
                }

            }

            if (gameOver) {
                System.out.println("GAME OVER");
            } else {
                imprimirFinal(ref);
            }

        }

    }

}
