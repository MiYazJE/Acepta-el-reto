import java.util.Scanner;
public class p629 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n, ans;
        int[] arr;

        while (true) {
            n = s.nextInt();
            if (n == 0) break;
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = s.nextInt();
            int prevLeft = 0;
            ans = 0;
            for (int i = n - 1; i > 0; i--) {
                int left = (i - arr[i]);
                if (left < 0) left = 0;
                if (i == n - 1) {
                    ans += i - left;
                    prevLeft = left;
                    continue;
                }
                if (left >= prevLeft) continue;
                if (i < prevLeft) ans += i - left;
                else ans += prevLeft - left;
                prevLeft = left;
            }
            System.out.println(ans);
        }

    }

}
