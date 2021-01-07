import java.util.LinkedList;
import java.util.Scanner;

public class p590 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<>();
        int n, K, best, temp, num;

        while (true) {
            n = s.nextInt();
            K = s.nextInt();
            if (n == 0 && K == 0) break;
            best = Integer.MAX_VALUE;
            temp = 0;
            while (n-- != 0) {
                num = s.nextInt();
                temp += num;
                if (temp >= K && temp < best) {
                    best = temp;
                    while (!list.isEmpty() && temp > K) {
                        temp -= list.removeFirst();
                        if (temp >= K) best = temp;
                    }
                }
                else {
                    while (!list.isEmpty() && temp > K) {
                        temp -= list.removeFirst();
                        if (temp >= K) best = Math.min(best, temp);
                    }
                }
                list.addLast(num);
            }
            System.out.println( best < K || best == Integer.MAX_VALUE ? "IMPOSIBLE" : best );
            list.clear();
        }

    }

}
