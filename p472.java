/**
 * @author Rubén Saiz
 */
package p472;

import java.util.Scanner;

public class p472 {

    static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        int max, n, temp;
        int n1, n2;
        boolean valid;

        while (s.hasNext()) {

            max = s.nextInt();
            n   = s.nextInt();

            valid = true;
            temp = 0;

            n1 = s.nextInt();
            for (int i = 1; i < n; i++) {
                n2 = s.nextInt();
                if (n2 > n1) {
                    temp += Math.abs(n1 - n2);
                }
                else {
                    temp = 0;
                }
                if (temp > max) {
                    valid = false; s.nextLine();
                    break;
                }
                n1 = n2;
            }

            System.out.println( (valid) ? "APTA" : "NO APTA" );
        }

    }

}
