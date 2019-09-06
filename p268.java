import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Desarrollo {

    public Double plato, corona;
    public Double relacion;

    public Desarrollo(int plato, int corona) {
        this.plato  = (double)plato;
        this.corona = (double)corona;
        calcular();
    }

    private void calcular() {
        relacion = plato / corona;
    }
}

class Sort implements Comparator<Desarrollo> {
    @Override
    public int compare(Desarrollo o1, Desarrollo o2) {
        if (o1.relacion < o2.relacion) return -1;
        if (o1.relacion > o2.relacion) return 1;
        return 0;
    }
}

public class p268 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int p, c;
        int plato, corona;
        int[] platos, coronas;
        ArrayList<Desarrollo> desarrollos;

        while (true) {

            p = s.nextInt();
            c = s.nextInt();

            if (p == 0 && c == 0) break;

            platos = new int[p]; coronas = new int[c];
            for (int i = 0; i < p; i++) platos[i] = s.nextInt();
            for (int i = 0; i < c; i++) coronas[i] = s.nextInt();

            desarrollos = new ArrayList<>();
            for (int i = 0; i < p; i++) {
                plato = platos[i];
                for (int j = 0; j < c; j++) {
                    corona = coronas[j];
                    desarrollos.add(new Desarrollo(plato, corona));
                }
            }

            Collections.sort(desarrollos, new Sort());

            for (int i = 0; i < desarrollos.size(); i++) {
                Desarrollo desarrollo = desarrollos.get(i);
                System.out.print(desarrollo.plato.intValue() + "-" + desarrollo.corona.intValue());
                if (i < desarrollos.size() - 1) System.out.print(" ");
            }

            System.out.println();
        }

    }

}
