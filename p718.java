import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p718 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();

        while (true) {
            int N = s.nextInt();
            if (N == 0) break;

            for (int i = 0; i < N; i++) {
                int x = s.nextInt();
                int current = map.containsKey(x) ? map.get(x) : 0;
                map.put(x, current + 1);
            }

            int sum = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                sum += (entry.getValue() / 2);
            }

            System.out.println( sum );

            map.clear();
        }

    }

}
