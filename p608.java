import java.util.Scanner;

public class p608 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int N, res;
        boolean flag;

        while (true) {
            N = s.nextInt();
            if (N == 0) break;
            res = 0;
            flag = true;
            for (int i = 0; i < N; i++) {
                int num = s.nextInt();
                if (flag && num <= 4) {
                    res++;
                    flag = false;
                }
                else if (num > 6) flag = true;
            }
            System.out.println(res);
        }

    }

}
