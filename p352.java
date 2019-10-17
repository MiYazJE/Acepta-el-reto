import java.util.*;

/**
 * @author Rubén Saiz
 */

public class p352 {

    static int indexOf(List<HashSet<Integer>> list, int num) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(num)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int max, n, m;
        int A, B;
        int r1, r2;
        ArrayList<HashSet<Integer>> listaConexos = new ArrayList<>();
        int casos = s.nextInt();

        while (casos-- != 0) {

            n = s.nextInt();
            m = s.nextInt();

            for (int i = 0; i < m; i++) {

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

            // Buscamos la lista con mas amigos
            max = 1;
            for (HashSet<Integer> list : listaConexos)
                max = Math.max(max, list.size());

            listaConexos.clear();
            System.out.println( Math.min(max, n) );
        }

    }

}
