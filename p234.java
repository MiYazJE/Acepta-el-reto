import java.util.Arrays;
import java.util.Scanner;

public class p234 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        int pilas, min, left, right,  res;
        int[] arr;

        while (casos-- != 0) {

            pilas = s.nextInt();
            min   = s.nextInt();
            arr   = new int[pilas];

            for (int i = 0; i < pilas; i++) arr[i] = s.nextInt();
            Arrays.sort(arr);
            
            left  = 0;
            right = pilas - 1;
            res   = 0;

            while (left < right) {
                if (arr[left] + arr[right] >= min) { right--; res++; }
                left++;
            }

            System.out.println( res );
        }

    }

}
