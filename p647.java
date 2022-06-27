import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p647 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Set<Integer> set = new HashSet<>();
        int ans, n;
        int arr[];
        int c = s.nextInt();

        while (c-- != 0) {
            n = s.nextInt();
            arr = new int[n];

            for (int i = 0; i < n; i++) arr[i] = s.nextInt();

            ans = 0;
            for (int i = 0, j = 0; i < n; i++) {
                if (set.contains(arr[i])) {
                    do {
                        set.remove(arr[j]);
                    } while (arr[j++] != arr[i]);
                }
                ans = Math.max(ans, i - j + 1);
                set.add(arr[i]);
            }

            System.out.println(ans);
            set.clear();
        }

    }

}
