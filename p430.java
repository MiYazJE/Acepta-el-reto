import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p430 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int pruebas, aux, n1, n2;
        while (true) {
            pruebas = s.nextInt();
            if (pruebas == 0) return; aux = 0;
            for (int i = 0; i < pruebas; i++) {
                n1 = s.nextInt(); n2 = s.nextInt();
                if (i == 0) aux = n1;
                else {
                    while (n1 <= aux)
                        n1 += n2;
                    aux = n1;
                }
            }
            System.out.println( aux );
        }
    }

}
