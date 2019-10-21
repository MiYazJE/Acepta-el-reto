import java.util.*;

class Piloto {
    int posicion;
    String nombre;
    Piloto(int p, String n) {
        posicion = p;
        nombre = n;
    }
    public String toString() {
        return posicion + nombre;
    }
}

class SortPilotos implements Comparator<Piloto> {
    public int compare(Piloto o1, Piloto o2) {
        return o1.posicion - o2.posicion;
    }
}

public class p331 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int n, pos;
        String name;
        ArrayList<Piloto> parrilla = new ArrayList<>();
        HashSet<Integer> repetidos = new HashSet<>();
        boolean valido;
        SortPilotos sort = new SortPilotos();

        while (true) {

            n = s.nextInt();
            if (n == 0) break;

            parrilla.clear();
            repetidos.clear();
            valido = true;

            for (int i = 0; i < n; i++) {
                pos = s.nextInt();
                name = s.nextLine();
                parrilla.add(new Piloto(pos+i+1, name));
                if (repetidos.contains(pos+i+1))     valido = false;
                if ((pos+i+1) < 1 || (pos+i+1) > 26) valido = false;
                repetidos.add(pos+i+1);
            }

            if (!valido) {
                System.out.println("IMPOSIBLE");
            }
            else {
                Collections.sort(parrilla, sort);
                for (Piloto piloto : parrilla)
                    System.out.println(piloto);
            }

            System.out.println("-----");
        }

    }

}
