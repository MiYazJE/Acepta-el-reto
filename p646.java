import java.util.*;

class Edge {

    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

class State {

    int node;
    int weight;

    public State(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Grafo {

    HashMap<Integer, LinkedList<Edge>> adyacentList;
    boolean[] visited;

    public Grafo(int size) {

        adyacentList = new HashMap<>();
        visited = new boolean[size + 1];

        for (int i = 1; i <= size; i++) {
            adyacentList.put(i, new LinkedList<Edge>());
        }

    }

    public void addPair(int A, int B, int weight) {
        this.adyacentList.get(A).addLast(new Edge(A, B, weight));
        this.adyacentList.get(B).addLast(new Edge(B, A, weight));
    }

    public void clear(int to) {
        for (int i = 1; i <= to; i++) {
            this.adyacentList.get(i).clear();
        }
    }

    public boolean bfs(int start, int dest, int minWeight, int N) {
        Arrays.fill(visited, 0, N + 1, false);
        Queue<State> q = new LinkedList<>();
        q.add(new State(start, 0));

        while (!q.isEmpty()) {
            State current = q.poll();
            if (current.node == dest) return true;
            visited[current.node] = true;
            for (Edge explore : this.adyacentList.get(current.node)) {
                if (visited[explore.to] || minWeight > explore.weight) continue;
                q.add(new State(explore.to, explore.weight));
            }
        }

        return false;
    }
}

public class p646 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        Grafo graph = new Grafo(10_001);
        int N, C;

        while (s.hasNext()) {

            N = s.nextInt();
            C = s.nextInt();

            for (int i = 0; i < C; i++)
                graph.addPair(s.nextInt(), s.nextInt(), s.nextInt());

            int queries = s.nextInt();
            for (int i = 0; i < queries; i++) {
                System.out.println(
                    graph.bfs(s.nextInt(), s.nextInt(), s.nextInt(), N)
                        ? "SI"
                        : "NO"
                );
            }

            graph.clear(N);
        }

    }

}
