import java.util.Arrays;
import java.util.Scanner;

public class p534 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos;
        int[] arr;
        int max;

        while (true) {

            casos = s.nextInt();
            if (casos == 0) break;

            arr = new int[casos];
            for (int i = 0; i < casos; i++) {
                arr[i] = s.nextInt();
            }

            Arrays.sort(arr);

            max = 0;
            for (int i = 0; i < casos - 1; i+=2) {
                max = Math.max(max, Math.abs(arr[i] - arr[i + 1]));
            }

            System.out.println( max );
        }
        
    }

}
