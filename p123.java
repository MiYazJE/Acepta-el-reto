import java.util.*;

/**
 * @author Rubén Saiz
 * 07/08/2019
 */

public class p123 {

    final static String[] persona = {"yo ", "tu ", "el ", "nosotros ", "vosotros ", "ellos "};

    public static void imprimirPresente(String verbo) {
        
        int len = verbo.length();
        String terminacion = verbo.substring(len - 2, len);

        for (int i = 0; i < 6; i++) {
            System.out.print(persona[i]);
            if (i == 0) System.out.println(verbo.substring(0, len-2) + "o");
            else if (i == 1) {
                if (terminacion.equals("ar")) System.out.println(verbo.substring(0, len-2) + "as");
                else System.out.println(verbo.substring(0, len-2) + "es");
            }
            else if (i == 2) {
                if (terminacion.equals("ar")) System.out.println(verbo.substring(0, len-2) + "a");
                else System.out.println(verbo.substring(0, len-2) + "e");
            }
            else if (i == 3) System.out.println(verbo.substring(0, len-1) + "mos");
            else if (i == 4) {
                if (terminacion.equals("ir")) System.out.println(verbo.substring(0, len-1) + "s");
                else System.out.println(verbo.substring(0, len-1) + "is");
            }
            else {
                if (terminacion.equals("ir")) System.out.println(verbo.substring(0, len-2) + "en");
                else System.out.println(verbo.substring(0, len-1) + "n");
            }
        }

    }

    public static void imprimirPreterito(String verbo) {

        int len = verbo.length();
        String terminacion = verbo.substring(len-2, len);

        for (int i = 0; i < 6; i++) {
            System.out.print(persona[i]);
            if (i == 0) {
                if (terminacion.equals("ar")) System.out.println(verbo.substring(0, len-2) + "e");
                else System.out.println(verbo.substring(0, len-2) + "i");
            }
            else if (i == 1) {
                if (terminacion.equals("ar")) System.out.println(verbo.substring(0, len-1) + "ste");
                else if (terminacion.equals("er")) System.out.println(verbo.substring(0, len-2) + "iste");
                else System.out.println(verbo.substring(0, len-1) + "ste");
            }
            else if (i == 2) {
                if (terminacion.equals("ar")) System.out.println(verbo.substring(0, len-2) + "o");
                else if (terminacion.equals("er")) System.out.println(verbo.substring(0, len-2) + "io");
                else System.out.println(verbo.substring(0, len-1) + "o");
            }
            else if (i == 3) {
                if (terminacion.equals("ar")) System.out.println(verbo.substring(0, len-1) + "mos");
                else if (terminacion.equals("er")) System.out.println(verbo.substring(0, len-2) + "imos");
                else System.out.println(verbo.substring(0, len-1) + "mos");
            }
            else if (i == 4) {
                if (terminacion.equals("ar")) System.out.println(verbo.substring(0, len-1) + "steis");
                else if (terminacion.equals("er")) System.out.println(verbo.substring(0, len-2) + "isteis");
                else System.out.println(verbo.substring(0, len-1) + "steis");
            }
            else {
                if (terminacion.equals("ar")) System.out.println(verbo + "on");
                else if (terminacion.equals("er")) System.out.println(verbo.substring(0, len-2) + "ieron");
                else System.out.println(verbo.substring(0, len-1) + "eron");
            }
        } 

    }

    public static void imprimirFuturo(String verbo) {

        final String[] conjunciones = {"e", "as", "a", "emos", "eis", "an"};

        for (int i = 0; i < 6; i++)
            System.out.println(persona[i] + verbo + conjunciones[i]);

    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String verbo;
        char conjuncion;

        while (true) {

            verbo = s.next();
            conjuncion = s.next().charAt(0);

            if (conjuncion == 'A')      imprimirPresente(verbo);
            else if (conjuncion == 'P') imprimirPreterito(verbo);
            else if (conjuncion == 'F') imprimirFuturo(verbo);
            else break;

        }

    }

}
