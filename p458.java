import java.util.*;

/**
 * @author Rubén Saiz
 * 23/10/2019
 */

public class p458 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int nums, n, indexNegative, indexPositive;
        long[] negatives, positives;
        boolean flagPositive, flagNegative;

        while (true) {

            nums = s.nextInt();
            if (nums == 0) break;

            negatives = new long[nums];
            positives = new long[nums];
            indexNegative = indexPositive = 0;
            flagPositive = flagNegative = false;

            for (int i = 0; i < nums; i++) {
                n = s.nextInt();
                if (n < 0) {
                    negatives[indexNegative++] = n;
                    flagNegative = true;
                }
                else {
                    positives[indexPositive++] = n;
                    flagPositive = true;
                }
            }

            Arrays.sort(negatives, 0, indexNegative);
            Arrays.sort(positives, 0, indexPositive);

            if (flagPositive && !flagNegative) {
                System.out.println(positives[indexPositive-1] * positives[indexPositive-2]);
            }
            else if (!flagPositive) {
                System.out.println(negatives[0] * negatives[1]);
            }
            else {
                long res1 = (indexPositive > 1) ?
                        positives[indexPositive-1] * positives[indexPositive-2] : -1;
                long res2 = (indexNegative > 1) ?
                        negatives[0] * negatives[1] : -1;
                if (res1 == -1 && res2 == -1) {
                    System.out.println( positives[0] * negatives[indexNegative-1] );
                }
                else {
                    System.out.println(Math.max(res1, res2));
                }
            }

        }

    }

}
