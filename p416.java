import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Rubén Saiz
 */

public class p416 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Set<String> cumples;
        String[] fecha;
        int casos;
        boolean repetido;

        while (true) {

            casos = s.nextInt();
            if (casos == 0) break;

            cumples = new TreeSet<>(); repetido = false;
            for (int i = 0; i < casos; i++) {
                fecha = s.next().split("/");
                if (cumples.contains(fecha[0] + " " + fecha[1])) { repetido = true; s.nextLine(); break; }
                else cumples.add( fecha[0] + " " + fecha[1] );
            }

            System.out.println( (repetido) ? "SI" : "NO" );
        }

    }

}
