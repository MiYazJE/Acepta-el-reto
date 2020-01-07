import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

class Coche {
    int pos, vel;
    Coche(int pos, int vel) {
        this.pos = pos;
        this.vel = vel;
    }
}

public class p545 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int viaje, n, res;
        ArrayList<Coche> coches = new ArrayList<>();

        while (s.hasNext()) {
            viaje = s.nextInt();
            n = s.nextInt();
            for (int i = 0; i < n; i++) {
                coches.add(new Coche(s.nextInt(), s.nextInt()));
            }
            res = Integer.MAX_VALUE;
            for (Coche coche : coches) {
                if (coche.pos >= 0) {
                    int tiempo = (viaje / coche.vel) + coche.pos;
                    res = Math.min(tiempo, res);
                }
            }
            System.out.println( (int)res );
            coches.clear();
        }


    }

}
