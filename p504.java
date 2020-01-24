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
        if (this.weight == state.weight) return this.streets - state.streets;
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

class Node implements Comparable<Node> {

    int node;
    int streets;

    public Node(int node, int calles) {
        this.node = node;
        this.streets = calles;
    }

    @Override
    public int compareTo(Node node) {
        return this.streets - node.streets;
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

    public int bfs(int start, int dest, int N) {
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        PriorityQueue<Node> q = new PriorityQueue<>();
        if (!this.adyacentList.get(start).isEmpty())
            q.add(new Node(start, 0));
        while (!q.isEmpty()) {
            Node current = q.poll();
            if (current.node == dest) return current.streets;
            for (Edge node : this.adyacentList.get(current.node)) {
                if (visited[node.to]) continue;
                visited[node.to] = true;
                q.add(new Node(node.to, current.streets + 1));
            }
        }
        return -1;
    }

    public State dijkstra(int start, int end, int N) {

        PriorityQueue<State> q = new PriorityQueue<>();
        int[]distance = new int[N + 1];
        for (int i = 1; i <= N; i++) distance[i] = Integer.MAX_VALUE;

        q.add(new State(start, 0, 0));
        distance[start] = 0;

        while (!q.isEmpty()) {

            State current = q.poll();

            if (distance[current.node] > current.weight) continue;
            if (current.node == end)
                return new State(0, current.streets, current.weight);

            for (Edge node : this.adyacentList.get(current.node)) {
                int weight = node.weight + current.weight;
                if (weight > distance[node.to]) continue;
                distance[node.to] = weight;
                q.add(new State(node.to, current.streets + 1, weight));
            }

        }

        return null;
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
        int N, C;
        int start, end, querys;

        while (s.hasNext()) {

            N = s.nextInt();
            C = s.nextInt();

            for (int i = 0; i < C; i++)
                graph.addPair(s.nextInt(), s.nextInt(), s.nextInt());

            querys = s.nextInt();
            for (int i = 0; i < querys; i++) {

                start = s.nextInt(); end = s.nextInt();
                if (C == 0) {
                    System.out.println("SIN CAMINO");
                    continue;
                }

                int minStreets = graph.bfs(start, end, N);
                if (minStreets == -1) System.out.println("SIN CAMINO");
                else {
                    State dijkstra = graph.dijkstra(start, end, N);
                    System.out.println(dijkstra.weight + " " + ((minStreets == dijkstra.streets) ? "SI" : "NO"));
                }
            }

            graph.clear(N);
            System.out.println("----");
        }

    }

}
