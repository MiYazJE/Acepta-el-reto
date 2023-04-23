import java.util.Arrays;
import java.util.Scanner;

public class p681 {

    static long getMany(int[] arr) {
        Arrays.sort(arr);
        long ans = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i + 1] <= 1) break;
            int parts = arr[i];
            if (arr[i] >= arr[i + 1]) parts = arr[i + 1] - 1;
            arr[i] = parts;
            ans += parts;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr;

        while (s.hasNext()) {
            int n = s.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = s.nextInt();
            System.out.println(getMany(arr));
        }
    }
}
