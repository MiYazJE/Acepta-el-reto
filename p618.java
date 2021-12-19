import java.util.Scanner;

public class p618 {

    static void solve(int[] arr, int left, int right) {
        int sum = 0;
        if (left < right) {
            for (int i = left + 1; i < right; i++) {
                sum += arr[i];
            }
        }
        else {
            for (int i = left; i >= right; i--) {
                sum -= arr[i];
            }
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n;
        int[] arr;

        while (true) {
            n = s.nextInt();
            if (n == 0) break;

            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = s.nextInt();

            n = s.nextInt();
            while (n-- != 0) solve(arr, s.nextInt() - 1, s.nextInt() - 1);
            System.out.println("---");
        }

    }

}
