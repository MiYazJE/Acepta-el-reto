import java.util.Scanner;

public class p621 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int c, num;

        c = s.nextInt();

        while (c-- != 0) {
            num = s.nextInt();
            System.out.println(num % 2 == 0 ? num + 1 : num - 1);
        }

    }

}
