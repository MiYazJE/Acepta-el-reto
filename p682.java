import java.util.Scanner;

public class p682 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int c = s.nextInt();
        while (c-- != 0) {
            int n = s.nextInt();
            System.out.println(n + " " + (n * 2));
        }

    }

}
