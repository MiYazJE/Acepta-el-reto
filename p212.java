import java.util.*;

/**
 * @author Rubén Saiz
 */

public class p212 {

    static boolean caminoEuleriano(int[] vertices, int max) {
        int impares = 0;

        for (int i = 1; i < max; i++) {
            if (vertices[i] % 2 != 0) impares++;
            if (impares > 2) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        int[] vertices = new int[1000];

        int A, B;
        int intersecciones, calles;

        while (true) {

            calles         = s.nextInt();
            if (calles == 0) break;
            intersecciones = s.nextInt();

            for (int i = 1; i <= intersecciones; i++)
                vertices[i] = 0;

            for (int i = 0; i < calles; i++) {
                A = s.nextInt();
                B = s.nextInt();
                vertices[A]++; vertices[B]++;
            }

            System.out.println( caminoEuleriano(vertices, intersecciones) ? "SI" : "NO" );
        }

    }

}
