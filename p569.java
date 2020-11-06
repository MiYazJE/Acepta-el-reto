import java.util.Scanner;

public class p569 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] split;
        int prev, current, finish, game, plus, C, ans, N = s.nextInt();

        while (N-- != 0) {
            game = s.nextInt();
            C = s.nextInt();

            ans = 0;
            plus = 0;
            prev = 480;

            while (C-- != 0) {
                split = s.next().split(":");
                finish = s.nextInt();
                current = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
                ans += (current - plus) - prev >= game ? (current - plus) - prev : 0;
                prev = current;
                plus = finish;
            }

            ans += 840 - plus - prev >= game ? 840 - plus - prev : 0;
            System.out.println( ans );
        }

    }

}
