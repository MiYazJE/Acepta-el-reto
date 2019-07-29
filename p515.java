import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p515 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int copas, turnos;

        while (true) {

            copas = s.nextInt();
            if (copas == 0) break;
            turnos = 0;

            while (copas > 0) {
                copas--; turnos++;
                if (copas <= 0) break;
                if (copas % 2 == 0) copas -= 2;
                else copas--;
                turnos++;
            }

            System.out.println( turnos );
        }

    }

}
