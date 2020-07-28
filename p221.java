import java.util.Scanner;

public class p221 {

    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        int[] queue;
        boolean flag, valid;
        int cases = s.nextInt(), n, pos;
        while (cases-- != 0) {
            n = s.nextInt();
            queue = new int[n];
            for (int i = 0; i < n; i++)
                queue[i] = s.nextInt();
            flag = false; valid = true;
            pos = 0;
            for (int num : queue) {
                if (flag && num % 2 == 0) {
                    valid = false;
                    break;
                }
                else if (num % 2 != 0) {
                    pos++;
                }
                flag = flag || num % 2 != 0;
            }
            System.out.println( valid ? "SI " + (n - pos) : "NO" );
        }
    }

}
