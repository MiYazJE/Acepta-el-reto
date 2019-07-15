package ejercicio120;

import java.util.Scanner;

public class p120 {

    public static void print(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int[][] m;
        boolean[][] visitados;
        int dim, num, i, j;
        int cMagica;

        while (true) {

            dim = s.nextInt();
            num = s.nextInt();
            if (dim == 0 && num == 0) break;

            m = new int[dim][dim];
            visitados = new boolean[dim][dim];

            i = 0;
            j = dim / 2;

            if (dim != 1) {
                while (true) {

                    if (i < 0) i = dim-1;
                    if (j == dim) j = 0;
                    if (visitados[i][j]) {
                        i += 2; j -= 1;
                    }

                    m[i][j] = num;
                    visitados[i][j] = true;
                    num++;

                    if (i == 0 && j == dim-1) break;
                    i--; j++;
                }
            }

            // print(m);

            cMagica = 0;
            for (i = dim-1; i >= 0; i--) {
                cMagica += m[i][(dim-1)-i];
            }

            if (dim == 1) System.out.println( num );
            else System.out.println( cMagica );

        }

    }

}
