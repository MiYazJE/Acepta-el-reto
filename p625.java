import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p625 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Integer[] arr;
        int n, best;
        boolean found;
        int c = s.nextInt();

        while (c-- != 0) {
            n = s.nextInt();

            arr = new Integer[n];
            for (int i = 0; i < n; i++) arr[i] = s.nextInt();
            Arrays.sort(arr, Collections.reverseOrder());

            best = 0;
            found = false;
            for (int i = 0; i < n - 2 && !found; i++) {
                if (arr[i] < (arr[i + 1] + arr[i + 2])) {
                    best = arr[i] + arr[i + 1] + arr[i + 2];
                    found = true;
                }
            }

            System.out.println(!found ? "NO HAY NINGUNO" : best);
        }

    }

}
