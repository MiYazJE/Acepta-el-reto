import java.io.*;
import java.util.*;

class State implements Comparable<State> {

    int id;
    int weight;

    public State(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    @Override
    public int compareTo(State state) {
        return this.weight - state.weight;
    }

}

class Edge {

    int id;
    int to;
    int weight;

    public Edge(int id, int to, int weight) {
        this.id = id;
        this.to = to;
        this.weight = weight;
    }
}

class Graph {

    HashMap<Integer, ArrayList<Edge>> adyacentList;

    public Graph() {
        this.adyacentList = new HashMap<>();
        for (int i = 1; i <= 1000; i++) {
            this.adyacentList.put(i, new ArrayList<Edge>());
        }
    }

    public void addEdge(int from, int to, int weight) {
        this.adyacentList.get(from).add(new Edge(from, to, weight));
    }

    public void canGo(int actualNode, int findNode, boolean[] visited) {
        visited[actualNode] = true;
        if (actualNode == findNode) return;
        for (Edge edge : this.adyacentList.get(actualNode)) {
            if (!visited[edge.to]) {
                canGo(edge.to, findNode, visited);
            }
        }
    }

    public void bfs(int end, boolean[] visited) {

        Queue<Integer> q = new ArrayDeque<>();
        int current = 1;
        visited[current] = true;
        q.add(current);

        while (!q.isEmpty()) {

            current = q.poll();
            if (current == end) return;

            for (Edge u : this.adyacentList.get(current)) {
                if (!visited[u.to]) {
                    visited[u.to] = true;
                    q.add(u.to);
                }
            }
        }
    }

    public int dijkstra(int findNode) {

        int minCost = 0;
        int[] weights = new int[findNode + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);

        PriorityQueue<State> q = new PriorityQueue<>();
        q.add(new State(1, 0));
        weights[1] = 0;

        while (!q.isEmpty()) {

            State current = q.poll();
            if (weights[current.id] < current.weight) continue;
            if (current.id == findNode) {
                minCost = current.weight;
                break;
            }

            for (Edge edge : this.adyacentList.get(current.id)) {
                int weight = edge.weight + current.weight;
                if (weights[edge.to] > weight) {
                    weights[edge.to] = weight;
                    q.add(new State(edge.to, weight));
                }
            }

        }

        return minCost;
    }

    void clear(int to) {
        for (int i = 1; i <= to; i++) {
            this.adyacentList.get(i).clear();
        }
    }

}

public class p318 {

    public static void main(String[] args) throws IOException {

        final BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

        int N, M;
        String input;
        String[] inputs;
        int[] weights = new int[1001];
        boolean[] visited = new boolean[1001];
        Graph graph = new Graph();

        while (true) {

            input = s.readLine();
            if (input == null) return;
            N = Integer.parseInt(input);

            input = s.readLine();
            int index = 1;
            for (String num : input.split(" ")) {
                weights[index++] = Integer.parseInt(num);
            }

            M = Integer.parseInt(s.readLine());
            for (int i = 0; i < M; i++) {
                inputs = s.readLine().split(" ");
                int from   = Integer.parseInt(inputs[0]);
                int to     = Integer.parseInt(inputs[1]);
                int weight = Integer.parseInt(inputs[2]) + weights[to];
                graph.addEdge(from, to, weight);
            }

            graph.bfs(N, visited);

            if (!visited[N]) {
                System.out.println( "IMPOSIBLE" );
            }
            else {
                int res = graph.dijkstra(N);
                System.out.println( res + weights[1] );
            }

            graph.clear(N);
            for (int i = 1; i <= N; i++) {
                weights[i] = 0;
                visited[i] = false;
            }
        }

    }

}
