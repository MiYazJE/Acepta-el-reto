import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p254 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int many, res;
        int[] esquiadores = new int[200_001];
        int[] esquis = new int[200_001];

        while (true) {

            many = s.nextInt();
            if (many == 0) break;

            for (int i = 0; i < many; i++) esquiadores[i] = s.nextInt();
            for (int i = 0; i < many; i++) esquis[i] = s.nextInt();

            Arrays.sort(esquiadores, 0, many);
            Arrays.sort(esquis, 0, many);

            res = 0;
            for (int i = 0; i < many; i++)
                res += Math.abs(esquiadores[i] - esquis[i]);

            System.out.println( res );
        }

    }


}
