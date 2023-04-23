import java.math.BigInteger;
import java.util.Scanner;

public class p677 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int c = s.nextInt();

        while (c-- != 0) {
            String num = s.next();
            System.out.println(new BigInteger(num).multiply(new BigInteger(num)));
        }
    }

}
