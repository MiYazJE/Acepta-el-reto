import java.util.*;

/**
 * @author Rubén Saiz
 * 23/10/2019
 */

class Localidad {
    int vecinos, premios;
    Localidad(int v, int p){
        vecinos = v;
        premios = p;
    }
    public String toString() {
        return vecinos + " " + premios;
    }
}

class SortLocalidades implements Comparator<Localidad> {
    @Override
    public int compare(Localidad o1, Localidad o2) {
        if (o1.vecinos == o2.vecinos) return o2.premios - o1.premios;
        return o2.vecinos - o1.vecinos;
    }
}

public class p378 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int localidades;
        boolean justo;
        ArrayList<Localidad> listaLocalidades = new ArrayList<>();
        SortLocalidades sort = new SortLocalidades();

        while (true) {

            localidades = s.nextInt();
            if (localidades == 0) break;

            justo = true;
            for (int i = 0; i < localidades; i++)
                listaLocalidades.add(new Localidad(s.nextInt(), s.nextInt()));

            Collections.sort(listaLocalidades, sort);

            for (int i = 0; i < listaLocalidades.size() - 1 && justo; i++) {
                Localidad actual = listaLocalidades.get(i);
                Localidad next   = listaLocalidades.get(i + 1);
                if (actual.vecinos == next.vecinos)
                    justo = actual.premios >= next.premios;
                else
                    justo = actual.premios > next.premios;
            }

            listaLocalidades.clear();
            System.out.println( (justo) ? "SI" : "NO" );
        }

    }

}
