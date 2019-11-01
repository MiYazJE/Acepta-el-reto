import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p375 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        String pista;
        int num;
        Character letra;

        while (s.hasNext()) {

            pista = s.next();

            num = Integer.parseInt(pista.substring(0, 2));
            letra = (pista.length() == 3) ? pista.charAt(2) : null;

            num = (18 + num) % 36;
            if (num == 0) num = 36;
            System.out.printf("%02d", num);

            if (letra != null) {
                if (letra == 'R')      System.out.print("L");
                else if (letra == 'L') System.out.print("R");
                else                   System.out.print("C");
            }

            System.out.println();
        }
 
    }

}
