import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p387 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos, max;
        String[] boletos;
        HashMap<Character, Integer> registro;
        char terminacion = '0';
        boolean varios;

        while (true) {

            casos = s.nextInt();
            if (casos == 0) break;

            boletos = new String[casos];
            registro = new HashMap<>();

            for (int i = 0; i < casos; i++) {
                boletos[i] = s.next();
                if (registro.containsKey(boletos[i].charAt(4))) {
                    registro.put(boletos[i].charAt(4), registro.get(boletos[i].charAt(4))+1);
                }
                else {
                    registro.put(boletos[i].charAt(4), 1);
                }
            }

            // Obtener el valor que mas se repite y comprobar si son diferentes
            max = 0;
            varios = false;
            for (Map.Entry<Character, Integer> entry : registro.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    terminacion = entry.getKey();
                    varios = false;
                }
                else if (entry.getValue() == max) {
                    varios = true;
                }
            }

            System.out.println( (varios) ? "VARIAS" : terminacion);

        }

    }

}
