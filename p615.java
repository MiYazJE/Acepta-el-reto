import java.util.Scanner;

public class p615 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, f, t, c = s.nextInt();
        while (c-- != 0) {
            n = s.nextInt();
            t = s.nextInt();
            f = s.nextInt();
            System.out.println((f % (n + 1)) * t);
        }
    }
 
}
