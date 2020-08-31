import java.util.Scanner;

public class p316 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        int n, num, ini, end, max, maxTemp, tempL;
        int cases = s.nextInt();

        while (cases-- != 0) {
            n = s.nextInt();
            ini = end = tempL = 0;
            max = maxTemp = 0;

            for (int i = 0; i < n; i++) {
                num = s.nextInt();

                maxTemp += num;
                if (num > max) {
                    max = num;
                    ini = end = (i + 1);
                }
                if (maxTemp > max || (maxTemp == max && (end - ini > (i - tempL)))) {
                    ini = tempL + 1;
                    end = i + 1;
                    max = maxTemp;
                }
                if (maxTemp <= 0) {
                    maxTemp = 0;
                    tempL = (i + 1);
                }
            }

            System.out.println( ini + " " + end );

        }

    }

}
