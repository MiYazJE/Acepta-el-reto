import java.util.*;

/**
 * @author Rubén Saiz
 * 06/08/2019
 */

public class p186 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int p, g, max, aux;
        boolean empate;

        while (true) {

            p = s.nextInt();
            g = s.nextInt();
            if (p == 0 && g == 0) break;
            int[] arr = new int[p + 1];

            for (int i = 1; i <= g; i++) { arr[s.nextInt()]++; s.next(); }

            max = 0; aux = -1; empate = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == aux) empate = true;
                if (aux < arr[i]) {
                    max = i; aux = arr[i]; empate = false;
                }
            }

            System.out.println( (empate) ? "EMPATE" :  max );
        }

    }

}
