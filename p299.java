import java.util.*;

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

        for (int i = 1; i <= this.size; i++) {
            adyacentList.put(i, new LinkedList<Edge>());
        }

    }

    public void addPair(int A, int B, int weight) {
        this.adyacentList.get(A).addLast(new Edge(A, B, weight));
        this.adyacentList.get(B).addLast(new Edge(B, A, weight));
    }

    public int prim(int start, boolean[] visited) {

        PriorityQueue<State> q = new PriorityQueue<>();
        int cost = 0;

        q.add(new State(start, 0));

        while (!q.isEmpty()) {

            State current = q.poll();

            if (visited[current.node]) continue;
            cost += current.weight;
            visited[current.node] = true;

            for (Edge node : this.adyacentList.get(current.node)) {
                if (visited[node.to]) continue;
                q.add(new State(node.to, node.weight));
            }

        }

        return cost;
    }

    public void clear(int to) {
        for (int i = 1; i <= to; i++) {
            this.adyacentList.get(i).clear();
        }
    }

}

public class p299 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        Graph graph = new Graph(20_001);
        int N, C;
        boolean[] visited;
        boolean connected;

        while (s.hasNext()) {

            N = s.nextInt();
            C = s.nextInt();

            for (int i = 0; i < C; i++)
                graph.addPair(s.nextInt(), s.nextInt(), s.nextInt());

            visited = new boolean[N + 1];
            int minCost = graph.prim(1, visited);

            connected = true;
            for (int i = 1; i <= N && connected; i++)
                connected = visited[i];

            System.out.println( (connected) ? minCost : "Imposible" );

            graph.clear(N);
        }

    }

}
