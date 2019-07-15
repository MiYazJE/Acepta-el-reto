import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p134 {

    public static void marcar(String[] marcados, String numero) {
        for (int i = 0; i < marcados.length; i++)
            if (marcados[i].equals(numero))
                marcados[i] = "0";
    }

    public static String valido(String[] marcados) {
        int cont = 0;
        boolean start = false, hueco = false;
        String output = "";
        for (int i = 0; i < marcados.length; i++) {
            if (marcados[i].equals("0")) {
                start = true;
                cont++;
            }
            else if (start) {
                if (hueco) return "NADA";
                hueco = true;
                output = marcados[i];
            }
            if (cont == 4 && hueco) return output + " " + palo;
            if (cont == 4 && i + 1 < marcados.length) return marcados[i+1] + " " + palo;
            else if (cont == 4) return marcados[i - 4] + " " + palo;
        }
        return "NADA";
    }

    public static char palo;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        final String[] baraja = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        final ArrayList<Character> palos = new ArrayList<>(Arrays.asList('P', 'D', 'T', 'C'));
        String carta;
        boolean leido, escalera;

        while (true) {

            leido = false;
            escalera = true;
            String[] marcados = Arrays.copyOf(baraja, baraja.length);

            for (int i = 0; i < 4; i++) {
                carta = s.next();
                if (carta.equals("0")) System.exit(0);
                if (leido) {
                    if (palo != s.next().charAt(0) || !palos.contains(palo)) {
                        escalera = false;
                        s.nextLine();
                        break;
                    }
                }
                else {
                    palo = s.next().charAt(0);
                    leido = true;
                }
                marcar(marcados, carta);
            }

            System.out.println( escalera ? valido(marcados) : "NADA" );

        }

    }

}
