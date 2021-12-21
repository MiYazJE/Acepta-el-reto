import java.util.Scanner;

public class p491 {

    static int many(int pos, int[] arr, long currentSum, int size, int eaten) {
        if (eaten == 12 && currentSum <= size) return 1;
        if (pos == arr.length || currentSum > size) return 0;
        return
            many(pos + 1, arr, currentSum + arr[pos], size, eaten + 1) +
            many(pos + 1, arr, currentSum, size, eaten);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, size;
        int[] arr;

        while (true) {
            size = s.nextInt();
            n = s.nextInt();
            if (size == 0 && n == 0) break;

            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = s.nextInt();

            int ans = many(0, arr,0, size, 0);
            System.out.println(ans);
        }
    }

}
