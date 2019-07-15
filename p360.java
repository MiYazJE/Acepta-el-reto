import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p360 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        int max, aguante, fuga, aux, veces;

        for (int i = 0; i < casos; i++) {

            max = s.nextInt();
            aguante = s.nextInt();

            veces = 0; aux = max;
            while (true) {
                fuga = s.nextInt();
                if (fuga == -1) break;
                aux -= fuga;
                if (aux < aguante) {
                    veces++;
                    aux = max;
                }
            }

            System.out.println( veces );

        }

    }

}
