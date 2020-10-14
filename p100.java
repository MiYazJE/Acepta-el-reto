import java.util.Arrays;
import java.util.Scanner;

public class p100 {

    public static int KAPREKAR = 6174;

    public static int ordAsc(char[] num) {
        Arrays.sort(num);
        return Integer.parseInt(new String(num));
    }

    public static int ordDesc(char[] num) {
        Arrays.sort(num);
        reverse(num);
        int n = Integer.parseInt(new String(num));
        return (n / 1000 == 0) ? multiplyNum(n) : n;
    }

    public static int multiplyNum(int num) {
        if (num != 0 && num < 1000) return multiplyNum(num * 10);
        return num;
    }

    public static void reverse(char[] num) {
        for (int i = 0; i < num.length / 2; i++) {
            char temp = num[num.length - i - 1];
            num[num.length - i - 1] = num[i];
            num[i] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        char[] num;
        int C = s.nextInt();

        while (C-- != 0) {

            num = s.next().toCharArray();

            if (Integer.parseInt(new String(num)) == KAPREKAR) {
                System.out.println( 0 );
                continue;
            }

            int iterations = 1;
            while (iterations < 8) {

                int desc = ordDesc(num);
                int asc  = ordAsc(num);
                int newNum = desc - asc;

                if (newNum == KAPREKAR) {
                    break;
                }

                num = String.valueOf(newNum).toCharArray();
                iterations++;
            }

            System.out.println( iterations );
        }

    }

}
