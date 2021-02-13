import java.util.Scanner;

public class p595 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        for (int i = s.nextInt(); i > 0; i--) {
            System.out.println(s.nextInt() / 100);
        }

    }

}
