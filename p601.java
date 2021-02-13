import java.util.*;

class Arista implements Comparable<Arista> {
    int coste, nodo;
    Arista(int n, int c) {
        this.nodo = n;
        this.coste = c;
    }

    @Override
    public int compareTo(Arista arista) {
        return this.coste - arista.coste;
    }
}

class Grafo {

    int size;
    HashMap<Integer, LinkedList<Arista>> listaAdyacencia;

    Grafo(int s) {
        this.size = s;
        listaAdyacencia = new HashMap<>();
        for (int i = 1; i <= this.size; i++) {
            listaAdyacencia.put(i, new LinkedList<Arista>());
        }
    }

    void agregarArista(int A, int B, int coste) {
        this.listaAdyacencia.get(A).add(new Arista(B, coste));
    }

    void limpiarAristas(int to) {
        for (int i = 1; i <= to; i++)
            this.listaAdyacencia.get(i).clear();
    }

    void dijkstra(int salida, int[] costes) {
        Arrays.fill(costes, Integer.MAX_VALUE);
        PriorityQueue<Arista> q = new PriorityQueue<>();
        q.add(new Arista(salida, 0));

        while (!q.isEmpty()) {
            Arista actual = q.poll();
            for (Arista explorar : this.listaAdyacencia.get(actual.nodo)) {
                int nuevoCoste = actual.coste + explorar.coste;
                if (nuevoCoste < costes[explorar.nodo]) {
                    costes[explorar.nodo] = nuevoCoste;
                    q.add(new Arista(explorar.nodo, nuevoCoste));
                }
            }
        }
    }

}

public class p601 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N, salida, tiempoMaximo, pasadizos, A, B, coste, ratones;
        int[] tiempos;
        Grafo grafo = new Grafo(100_000 );

        while (s.hasNext()) {
            N = s.nextInt();
            salida = s.nextInt();
            tiempoMaximo = s.nextInt();
            pasadizos = s.nextInt();
            tiempos = new int[N + 1];

            while (pasadizos-- != 0) {
                A = s.nextInt();
                B = s.nextInt();
                coste = s.nextInt();
                grafo.agregarArista(B, A, coste);
            }

            grafo.dijkstra(salida, tiempos);

            ratones = 0;
            for (int i = 1; i <= N; i++) {
                if (i != salida && tiempos[i] <= tiempoMaximo)
                    ratones++;
            }

            System.out.println( ratones );
            grafo.limpiarAristas(N);
        }

    }

}
