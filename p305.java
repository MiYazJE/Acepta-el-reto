import java.util.Arrays;
import java.util.Scanner;

public class p305 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int[] enemigos = new int[100_001];
        int[] defensa  = new int[100_001];
        int ciudades, res, index;
        int min, value, pos;

        while (s.hasNext()) {

            ciudades = s.nextInt();

            min = Integer.MIN_VALUE;
            for (int i = 0; i < ciudades; i++) {
                enemigos[i] = s.nextInt();
                min = Math.min(min, enemigos[i]);
            }

            pos = 0;
            for (int i = 0; i < ciudades; i++) {
                value = s.nextInt();
                if (value >= min)
                    defensa[pos++] = value;
            }

            Arrays.sort(enemigos, 0, ciudades);
            Arrays.sort(defensa, 0, pos);

            res = index = 0;
            for (int i = 0; i < pos && index < pos; i++) {
                if (enemigos[i] <= defensa[index])
                    res++;
                else
                    i--;
                index++;
            }

            System.out.println( res );
        }

    }

}
