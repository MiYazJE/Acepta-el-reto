import java.util.HashMap;
import java.util.Scanner;

public class p338 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N, K, busted, copies, n;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(s.hasNext()) {
            N = s.nextInt();
            K = s.nextInt();
            
            busted = copies = 0;
            for (int i = 1; i <= N; i++) {
                n = s.nextInt();
                boolean contains = map.containsKey(n);
            
                if (contains && i - map.get(n) <= K) {
                    busted++;
                }
                if (contains) copies++;
                map.put(n, i);
            }
            
            System.out.printf("%d %d\n", copies, busted);
            map.clear();
        }

    }

}
