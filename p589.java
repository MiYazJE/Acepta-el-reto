import java.util.*;

public class p589 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        long N, ans, max;

        while (true) {
            N = s.nextLong();
            if (N == 0) break;
            ans = 0L;
            max = s.nextLong();
            for (long i = 1; i < N; i++) {
                long num = s.nextLong();
                if (max < num) {
                    ans += (num * i) - (max * i);
                    max = num;
                }
                else ans += max - num;
            }
            System.out.println(ans);
        } 

    }

}
