import java.util.Scanner;

public class p670 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] gains = new int[n];
            for (int i = 0; i < n; i++) {
                gains[i] = sc.nextInt();
            }
            System.out.println(maximumProfit(gains, k + 1));
        }
    }

    private static long maximumProfit(int[] gains, int k) {
        int n = gains.length;
        long[][] dp = new long[n][2];
        dp[0][0] = 0;
        dp[0][1] = gains[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            if (i >= k) {
                dp[i][1] = Math.max(dp[i - k][0], dp[i - k][1]) + gains[i];
            } else {
                dp[i][1] = gains[i];
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
