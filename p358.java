import java.util.*;

class State implements Comparable<State> {

    int id;
    int weight;

    public State(int node, int weight) {
        this.id = node;
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

    public void addEdge(int A, int B, int weight) {
        this.adyacentList.get(A).addLast(new Edge(A, B, weight));
        this.adyacentList.get(B).addLast(new Edge(B, A, weight));
    }

    public int dijkstra(int[] weights, int[] dp, int findNode) {

        PriorityQueue<State> q = new PriorityQueue<>();
        q.add(new State(1, 0));
        weights[1] = 0;
        dp[1] = 1;

        while (!q.isEmpty()) {

            State current = q.poll();
            if (weights[current.id] < current.weight) continue;

            for (Edge edge : this.adyacentList.get(current.id)) {
                int weight = edge.weight + current.weight;
                if (weights[edge.to] < weight) continue;
                if (weights[edge.to] == weight) {
                    dp[edge.to] += dp[current.id];
                    continue;
                }
                dp[edge.to] = dp[edge.from];
                weights[edge.to] = weight;
                q.add(new State(edge.to, weight));
            }

        }

        return dp[findNode];
    }

    public void clear(int to) {
        for (int i = 1; i <= to; i++) {
            this.adyacentList.get(i).clear();
        }
    }

}

public class p358 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int N, C;
        int[] weights = new int[10_001];
        int[] dp = new int[10_001];
        Graph graph = new Graph(10_001);

        while (s.hasNext()) {
            N = s.nextInt();
            C = s.nextInt();
            for (int i = 1; i <= N; i++) {
                dp[i] = 0;
                weights[i] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < C; i++)
                graph.addEdge(s.nextInt(), s.nextInt(), s.nextInt());
            System.out.println( graph.dijkstra(weights, dp, N) );
            graph.clear(N);
        }

    }

}
