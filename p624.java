import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p624.java {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n, max, num;
        Set<Integer> set = new HashSet<Integer>();

        while (true) {
            n = s.nextInt();
            if (n == 0) break;
            max = 0;
            for (int i = 0; i < n; i++) {
                num = s.nextInt();
                if (set.contains(num)) set.remove(num);
                else set.add(num);
                max = Math.max(max, set.size());
            }
            System.out.println(max);
        }

    }

}
