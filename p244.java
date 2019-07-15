import java.util.Scanner;

public class p244 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int numReinas, dim;
        int[] arrX, arrY;
        boolean colision;

        while (true) {

            dim = s.nextInt();
            numReinas = s.nextInt();
            if (dim == 0 && numReinas == 0) break;

            arrX = new int[numReinas];
            arrY = new int[numReinas];

            for (int i = 0; i < numReinas; i++)  {
                arrX[i] = s.nextInt();
                arrY[i] = s.nextInt();
            }

            colision = false;
            for (int i = 0; i < numReinas; i++) {
                int x = arrX[i];
                int y = arrY[i];
                for (int j = 0; j < numReinas; j++) {
                    if (j == i) continue;
                    int c = arrX[j];
                    int f = arrY[j];
                    if (((y - x == f - c) || (x == c || y == f)) ||
                        ((x - c == y - f) || (x - c == f - y))) {
                        colision = true;
                        break;
                    }
                }
                if (colision) break;
            }

            System.out.println( (colision) ? "SI" : "NO");
        }

    }

}
