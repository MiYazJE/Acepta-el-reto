import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p206 {

    static int calc(int d, int l) {
        if (d < 0) return 0;
        double lado = Math.sqrt((d*d) - (l*l));
        if ((int)lado == lado) return (int)lado + l;
        return calc(d, l-1);
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        int distancia;

        while (casos-- != 0) {
            distancia = s.nextInt();
            System.out.println( calc(distancia, distancia-1) );
        }

    }

}
