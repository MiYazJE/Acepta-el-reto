import java.util.*;

/**
 * @author Rubén Saiz
 * 18/12/2019
 */

public class p537 {

    static int indexOf(List<HashSet<Integer>> list, int num) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(num)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int P, C, r1, r2, A, B;
        boolean good;
        ArrayList<HashSet<Integer>> listaConexos = new ArrayList<>();

        while (s.hasNext()) {

            P = s.nextInt();
            C = s.nextInt();

            for (int i = 0; i < C; i++) {

                A = s.nextInt();
                B = s.nextInt();

                r1 = indexOf(listaConexos, A);
                r2 = indexOf(listaConexos, B);

                // Si los dos no se encuentran creamos una lista con ellos
                if (r1 == -1 && r2 == -1) {
                    HashSet<Integer> nuevaLista = new HashSet<>();
                    nuevaLista.add(A);
                    nuevaLista.add(B);
                    listaConexos.add(nuevaLista);
                }
                // si los dos se encuentran en diferentes listas
                else if (r1 != -1 && r2 != -1 && r1 != r2) {
                    // fusionamos
                    HashSet<Integer> listDeleted = listaConexos.get(r1);
                    listaConexos.get(r2).addAll(listDeleted);
                    // eliminamos
                    listaConexos.remove(r1);
                }
                else if (r2 == -1) {
                    listaConexos.get(r1).add(B);
                }
                else if (r1 == -1) {
                    listaConexos.get(r2).add(A);
                }

            }

            good = (listaConexos.size() == 1 &&
                    listaConexos.get(0).size() == P);

            if (P == 1) good = true;

            System.out.println( good ? "BICI" : "A PIE" );
            listaConexos.clear();
        }

    }

}
