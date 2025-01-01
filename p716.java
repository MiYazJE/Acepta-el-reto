import java.util.Scanner;

public class p716 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        while (true) {
            int N = s.nextInt();
            if (N == 0) break;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += s.nextInt();
            }
            System.out.println(sum - (N - 1));
        }
    }

}
