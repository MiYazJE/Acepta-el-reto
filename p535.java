import java.util.Scanner;

public class p535 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos, max, res;
        int[] arr;

        while (true) {

            casos = s.nextInt();
            if (casos == 0) break;

            arr = new int[casos];

            max = 0;
            for (int i = 0; i < casos; i++) {
                arr[i] = s.nextInt();
                max = Math.max(max, arr[i]);
            }

            res = 0;
            for (int i = 0; i < casos; i++) {
                res += Math.abs(max - arr[i]);
            }

            System.out.println( res );
        }

    }

}
