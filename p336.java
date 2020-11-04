import java.util.Scanner;

public class p336 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        int n, best, sum1, sum2, left, right, leftSide;
        boolean valid;
        int[] arr = new int[300_001];

        while (s.hasNext()) {
            n = s.nextInt();

            sum1 = sum2 = left = right = leftSide = 0;
            best = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
                sum1 += arr[i];
            }

            valid = true;
            for (int i = 0; i < n && valid; i++) {
                sum1 -= arr[i];
                sum2 += arr[i];
                if (Math.abs(sum2 - sum1) == best) {
                    valid = false;
                }
                else if (Math.abs(sum2 - sum1) < best) {
                    best = Math.abs(sum2 - sum1);
                    left = sum2;
                    right = sum1;
                    leftSide = i + 1;
                }
            }

            System.out.println(
                    valid
                        ? (leftSide + " " + left + " " + right)
                        : "NO JUEGAN"
            );
        }

    }

}
