import java.util.Scanner;

public class p229 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int n, sum1, sum2, ans;
        int[] arr;

        while (true) {
            n = s.nextInt();
            if (n == 0) break;
            arr = new int[n];

            sum1 = 0;
            for (int i = 0; i < n; i++) {
                int num = s.nextInt();
                arr[i] = num;
                sum1 += num;
            }

            sum2 = 0;
            ans = sum1 == sum2 ? 1 : 0;
            for (int i = 0; i < n; i++) {
                int num = arr[i];
                sum1 -= num;
                sum2 += num;
                ans += sum1 == sum2 ? 1 : 0;
            }

            System.out.println( ans );
        }

    }

}
