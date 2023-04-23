import java.util.Scanner;

public class p664 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n, num, ans;

        while (true) {
            n = s.nextInt();
            if (n == 0) break;

            ans = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                num = s.nextInt();
                int temp = -1;
                for (int j = 0; j < num; j++) {
                    temp = Math.max(temp,  s.nextInt());
                }
                ans = Math.min(ans, temp);
            }


            System.out.println( ans );
        }

    }

}
