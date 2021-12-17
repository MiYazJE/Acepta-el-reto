import java.util.Scanner;

public class p606 {

    static int getMax(int[] arr, int[] pre, int current) {
        if (pre[current] != 0) return pre[current];
        int max = 0;
        for (int i = current + 1; i < arr.length; i++) {
            if (arr[current] < arr[i]) {
                max = Math.max(max, getMax(arr, pre, i));
            }
        }
        return pre[current] = max + 1;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n, ans;
        int[] arr, pre;

        while (true) {
            n = s.nextInt();
            if (n == 0) break;

            arr = new int[n];
            pre = new int[n];

            for (int i = 0; i < n; i++) arr[i] = s.nextInt();

            ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, getMax(arr, pre, i));
            }

            System.out.println(ans);
        }

    }

}
