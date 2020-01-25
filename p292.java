import java.util.*;

/**
 * @author Rubén Saiz
 */

class State implements Comparable<State> {

    int node;
    int weight;

    public State(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(State state) {
        return this.weight - state.weight;
    }
}

class Edge {

    int from, to;
    int weight;

    public Edge(int from, int node, int weight) {
        this.from = from;
        this.to = node;
        this.weight = weight;
    }

}

class Graph {

    HashMap<Integer, LinkedList<Edge>> adyacentList;
    int size;

    public Graph(int size) {

        this.size = size;
        adyacentList = new HashMap<>();

        for (int i = 1; i <= this.size; i++)
            adyacentList.put(i, new LinkedList<Edge>());

    }

    public void addEdge(int A, int B, int weight) {
        this.adyacentList.get(A).addLast(new Edge(A, B, weight));
    }

    public void clear() {
        for (int i = 1; i <= this.size; i++) {
            this.adyacentList.get(i).clear();
        }
    }

    public void dijkstra(int start, int[] distances) {

        PriorityQueue<State> q = new PriorityQueue<>();
        Arrays.fill(distances, Integer.MAX_VALUE);

        q.add(new State(start, 0));
        distances[start] = 0;

        while (!q.isEmpty()) {

            State current = q.poll();
            if (current.weight > distances[current.node]) continue;

            for (Edge node : this.adyacentList.get(current.node)) {
                int weight = current.weight + node.weight;
                if (weight >= distances[node.to]) continue;
                distances[node.to] = weight;
                q.add(new State(node.to, weight));
            }

        }

    }

}

public class p292 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N, C, oficina, paquetes, minCost;
        int from, to, weight;
        int costGo, costBack;
        int[] distances, distances2;
        boolean imposible;

        while (s.hasNext()) {

            N = s.nextInt();
            C = s.nextInt();

            Graph graph = new Graph(N + 1);
            Graph graph2 = new Graph(N + 1);

            for (int i = 0; i < C; i++) {
                from   = s.nextInt();
                to     = s.nextInt();
                weight = s.nextInt();
                graph.addEdge(from, to, weight);
                graph2.addEdge(to, from, weight);
            }

            oficina = s.nextInt();
            paquetes = s.nextInt();

            distances  = new int[N + 1];
            distances2 = new int[N + 1];
            graph.dijkstra(oficina, distances);
            graph2.dijkstra(oficina, distances2);

            minCost = 0;
            imposible = false;

            for (int i = 0; i < paquetes; i++) {

                int casa = s.nextInt();

                if (!imposible) {

                    costGo   = distances[casa];

                    if (costGo != Integer.MAX_VALUE) {
                        minCost += costGo;
                    }
                    else imposible = true;

                    if (!imposible) {
                        costBack = distances2[casa];
                        if (costBack != Integer.MAX_VALUE) {
                            minCost += costBack;
                        }
                        else imposible = true;
                    }

                }

            }

            if (imposible) {
                System.out.println("Imposible");
            }
            else {
                System.out.println( minCost );
            }

        }

    }

}
