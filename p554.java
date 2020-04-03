import java.util.Scanner;

public class p554 {

    public static long numWays(int stairs, int[] arr, long[] dp) {
        if (stairs < 0)  return 0l;
        if (stairs == 0) return 1l;
        if (dp[stairs - 1] == 0) {
            for (int i = 0; i < arr.length; i++) {
                long res = numWays(stairs - arr[i], arr, dp);
                dp[stairs - 1] = (res + dp[stairs - 1]) % 1_000_000_007;
            }
        }
        return dp[stairs - 1];
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int stairs, n;
        int[] arr;
        long[] dp;

        while (true) {
            stairs = s.nextInt();
            if (stairs == 0) break;
            dp = new long[stairs];
            n = s.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            System.out.println( numWays(stairs, arr, dp) );
        }

    }

}
