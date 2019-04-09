import java.util.*;

public class p466 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        String n1, n2, output;
        int acarreo, len, n;

        for (int j = 0; j < casos; j++) {

            n1 = s.next();
            n2 = s.next();

            if (n1.length() < n2.length()) {
                while (n1.length() < n2.length()) {
                    n1 = "0" + n1;
                }
            }
            else if (n2.length() < n1.length()) {
                while (n2.length() < n1.length()) {
                    n2 = "0" + n2;
                }
            }

            len = n1.length()-1;
            acarreo = 0;
            output = "";

            for (int i = len; i >= 0; i--) {
                n = Integer.parseInt(""+n1.charAt(i)) * Integer.parseInt(""+n2.charAt(i)) + acarreo;
                acarreo = n / 10;
                if (i-1 != -1) n = n % 10;
                output = n + output;
            }

            System.out.println(output);
        }

    }

}
