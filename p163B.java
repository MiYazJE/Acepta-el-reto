import java.math.BigInteger;
import java.util.Scanner;

public class p163B   {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String num;

        while (true) {
            num = s.next();
            if (num.equals("FIN")) break;
            BigInteger n = new BigInteger(num, 16).add(BigInteger.ONE);
            System.out.println(n.toString(16).toUpperCase());
        }

    }

}
