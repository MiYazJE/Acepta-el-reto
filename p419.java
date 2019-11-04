import java.util.Arrays;
import java.util.Scanner;

public class p419 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int max, many, res, left, right;
        int[] personas;

        while (true) {

            max  = s.nextInt();
            many = s.nextInt();
            if (max == 0 && many == 0) break;

            personas = new int[many];

            for (int i = 0; i < many; i++)
                personas[i] = s.nextInt();

            Arrays.sort( personas );

            res = left = 0;
            right = many - 1;

            while (left <= right) {
                if (left == right) { res++; left++; right--;}
                else if (personas[left] + personas[right] <= max) {
                    right--; left++;
                    res++;
                }
                else {
                    res++;
                    right--;
                }
            }

            System.out.println( res );
        }

    }

}
