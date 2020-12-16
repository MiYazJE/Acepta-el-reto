import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p578 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n;
        Set<String> set = new HashSet<>();

        while (true) {
            n = s.nextInt();
            s.nextLine();
            if (n == 0) break;
            for (int i = 0; i < n; i++) {
                set.add(s.nextLine().toLowerCase());
            }
            System.out.println( set.size() );
            set.clear();
        }

    }

}
