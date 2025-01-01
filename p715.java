import java.util.Scanner;

public class p715 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int C = s.nextInt();

        while (C-- != 0) {
            int a = s.nextInt();
            int b = s.nextInt();
            System.out.println( a / 12 >= b ? "SI" : "NO" );
        }

    }

}
