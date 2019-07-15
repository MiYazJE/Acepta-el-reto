import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p400 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String linea;
        char[] camas;
        int max, len, distancia;
        boolean first;

        while (s.hasNext()) {

            linea = s.next();

            camas = linea.toCharArray();
            max = distancia = 0;
            len = camas.length;
            first = false;

            for (int i = 0; i < len; i++) {
                if (camas[i] == '.') {
                    distancia++;
                    if (i == 0) first = true;
                    if (i == len-1) max = Math.max(distancia-1, max);
                }
                else {
                    if (first) {
                        max = Math.max(distancia-1, max);
                        first = false;
                    }
                    else if (distancia %2 == 0) {
                        max = Math.max(max, distancia/2-1);
                    }
                    else {
                        max = Math.max(max, distancia/2); // X....X
                    }
                    distancia = 0;
                }
            }

            System.out.println( max );
        }

    }

}
