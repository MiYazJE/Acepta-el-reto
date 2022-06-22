import java.util.Scanner;

public class p641 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int k, n;
        long ans;
        long[] sums;
        
        while (true) {
            k = s.nextInt();
            n = s.nextInt();
            if (k == 0 && n == 0) break;
            
            long sum = 0;
            sums = new long[n];
            ans = 0;
            
            for (int i = 0; i < n; i++) {
                int num = s.nextInt();
                if (i < k) ans += num;
                sum += (long) num;
                sums[i] = sum;
            }
            
            for (int i = 1; i < n - k + 1; i++) {
                ans = Math.max(ans, sums[i + k - 1] - sums[i - 1]);
            }
            
            System.out.println(ans);
        }
    }
}
