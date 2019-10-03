import java.math.BigInteger;
import java.util.Scanner;

public class p163 {

    static String getDecimalValue(char n) {
        if (n <= '9') return ""+n;
        if (n == 'A') return "10";
        if (n == 'B') return "11";
        if (n == 'C') return "12";
        if (n == 'D') return "13";
        if (n == 'E') return "14";
        if (n == 'F') return "15";
        return "0";
    }

    static String getHexValue(long n) {
        if (n <= 9) return ""+n;
        if (n == 10) return "A";
        if (n == 11) return "B";
        if (n == 12) return "C";
        if (n == 13) return "D";
        if (n == 14) return "E";
        if (n == 15) return "F";
        return "0";
    }

    static String toDecimal(String hex) {
        BigInteger decimal = new BigInteger("0");
        BigInteger pow;
        BigInteger sum;
        int x = 0;
        for (int i = hex.length()-1; i >= 0; i--) {
            pow = MOD.pow(x++);
            sum = new BigInteger(getDecimalValue(hex.charAt(i)));
            sum = sum.multiply(pow);
            decimal = decimal.add(sum);
        }
        return decimal.toString();
    }

    final static BigInteger MOD = new BigInteger("16");
    static String toHex(BigInteger num, String hex) {
        if (num.compareTo(BigInteger.ZERO) <= 0) return hex;
        hex = getHexValue(num.mod(MOD).intValue()) + hex;
        return toHex((num.divide(MOD)), hex);
    }

    static String sumaleUno(String num) {
        BigInteger decimal = new BigInteger(toDecimal(num));
        return toHex(decimal.add(BigInteger.ONE), "");
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        String num;

        while (true) {
            num = s.next();
            if (num.equals("FIN")) break;
            System.out.println( sumaleUno(num) );
        }

    }

}
