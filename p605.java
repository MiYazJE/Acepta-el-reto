import java.util.Scanner;

public class p605 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String c;
        int verano, invierno;

        while (true) {
            verano = invierno = 0;
            c = s.next();
            if (c.equals(".")) break;
            while (true) {
                if (c.equals(".")) break;
                if (c.equals("V")) verano++;
                else if (c.equals("I")) invierno++;
                c = s.next();
            }
            if (verano > invierno) {
                System.out.println("VERANO");
            }
            else if (invierno > verano) {
                System.out.println("INVIERNO");
            }
            else System.out.println("EMPATE");
        }

    }

}
