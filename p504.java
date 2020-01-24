import java.util.*;

class State implements Comparable<State> {

    int node;
    int streets;
    int weight;

    public State(int node, int streets, int weight) {
        this.node = node;
        this.streets = streets;
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

    public void clear(int to) {
        for (int i = 1; i <= to; i++) {
            this.adyacentList.get(i).clear();
        }
    }

}

public class p504 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        Graph graph = new Graph(20_001);
        boolean found, flag;
        boolean[] visited;
        int N, C;
        int distance[];
        int start, end, querys, bestWeight, streets;
        State current;

        while (s.hasNext()) {

            N = s.nextInt();
            C = s.nextInt();

            for (int i = 0; i < C; i++)
                graph.addPair(s.nextInt(), s.nextInt(), s.nextInt());

            querys = s.nextInt();
            for (int i = 0; i < querys; i++) {

                start = s.nextInt(); end = s.nextInt();
                found = flag = false;
                PriorityQueue<State> q = new PriorityQueue<>();
                visited = new boolean[N + 1];
                distance = new int[N + 1];
                for (int j = 1; j <= N; j++) distance[j] = Integer.MAX_VALUE;
                bestWeight = -1;
                streets = -1;

                q.add(new State(start, 0, 0));
                distance[start] = 0;

                while (!q.isEmpty()) {

                    current = q.poll();
                    visited[current.node] = true;
                    if (found && current.streets >= streets) continue;

                    if (current.node == end) {
                        if (bestWeight == -1) {
                            bestWeight = current.weight;
                            streets = current.streets;
                            found = true;
                        }
                        else flag = true;
                    }

                    for (Edge node : graph.adyacentList.get(current.node)) {
                        if (visited[node.to]) continue;
                        int weight = node.weight + current.weight;
                        if (weight < distance[current.node]) {
                            distance[node.to] = weight;
                        }
                        if (!found || current.streets <= streets)
                            q.add(new State(node.to, current.streets + 1, weight));
                    }

                }

                if (!found) {
                    System.out.println("SIN CAMINO");
                }
                else {
                    System.out.println(bestWeight + ((!flag) ? " SI" : " NO"));
                }

            }

            graph.clear(N);
            System.out.println("----");
        }

    }

}
