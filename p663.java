import java.util.Scanner;

public class p663 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int c = s.nextInt();

        while (c-- != 0) {
            int n = s.nextInt();
            System.out.println( n > 0 ? n - 1 : n );
        }

    }

}
