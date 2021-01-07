import java.util.Arrays;
import java.util.Scanner;

public class p586 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int cases = s.nextInt(), N, n1, n2, ans;
        String[] arr;

        for (int i = 0; i < cases; i++) {
            N = s.nextInt();
            s.nextLine();
            arr = s.nextLine().split(" ");
            Arrays.sort(arr);
            ans = 0;
            n1 = Integer.parseInt(arr[0]);
            for (int j = 1; j < N; j++) {
                n2 = Integer.parseInt(arr[j]);
                ans += n2 - 1 - n1;
                n1 = n2;
            }
            System.out.println(ans);
        }

    }

}
