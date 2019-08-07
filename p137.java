import java.util.ArrayList;
import java.util.Scanner;

public class p137 {

    public static void obtenerSize(int[][] m, int i, int j) {
        if (!safe(m, i, j)) {

        }
        else if (m[i][j] == 1) {
            if (contieneDiagonal(m, i, j)) {
                correcto = false;
                return;
            }
            size++;
            m[i][j] = 2;
            obtenerSize(m, i+1, j);
            obtenerSize(m, i-1, j);
            obtenerSize(m, i, j+1);
            obtenerSize(m, i, j-1);
        }
    }

    public static boolean contieneDiagonal(int[][] m, int i, int j) {
        return ( (safe(m, i-1, j-1) && m[i-1][j-1] != 0) ||  // arriba izq
                (safe(m, i+1, j+1) && m[i+1][j+1] != 0) ||  // abajo  der
                (safe(m, i+1, j-1) && m[i+1][j-1] != 0) ||  // abajo  izq
                (safe(m, i-1, j+1) && m[i-1][j+1] != 0) );  // arriba der
    }

    public static boolean safe(int[][] m, int i, int j) {
        return (i >= 0 && j >= 0 && i < m.length && j < m[0].length);
    }

    public static int size;
    public static boolean correcto;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int numBarcos, dim;
        ArrayList<Integer> tamanyos;
        int[][] m;
        boolean noBarcos;

        while (true) {

            numBarcos = s.nextInt();
            if (numBarcos == 0) break;

            tamanyos = new ArrayList<>();
            correcto = noBarcos = true;

            // LECTURA DE LOS BARCOS
            for (int i = 0; i < numBarcos; i++) tamanyos.add(s.nextInt());

            // dimensiones del tablero
            dim = s.nextInt();
            m = new int[dim][dim];

            // Lectura del tablero
            for (int i = 0; i < dim; i++)
                for (int j = 0; j < dim; j++) {
                    m[i][j] = s.nextInt();
                    if (m[i][j] == 1) noBarcos = false;
                }

            if (noBarcos) System.out.println("NO");
            else {
                for (int i = 0; i < dim; i++) {
                    for (int j = 0; j < dim; j++) {
                        size = 0;
                        if (m[i][j] == 1) {
                            obtenerSize(m, i, j);
                            if (correcto && tamanyos.contains(size)) {
                                tamanyos.remove(Integer.valueOf(size));
                            } else {
                                correcto = false;
                                break;
                            }
                        }
                    }
                    if (!correcto) break;
                }

                System.out.println( (correcto && tamanyos.isEmpty()) ? "SI" : "NO" );
            }

        }

    }

}
