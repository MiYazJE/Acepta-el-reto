import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

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

class Node {

    int to;
    int weight;

    public Node(int node, int weight) {
        this.to = node;
        this.weight = weight;
    }

}

class Graph {

    HashMap<Integer, ArrayList<Node>> adyacentList;
    int size;

    public Graph(int size) {

        this.size = size;

        this.adyacentList = new HashMap<>();
        for (int i = 1; i <= this.size; i++) {
            this.adyacentList.put(i, new ArrayList<>());
        }
        
    }

    public void addPair(int A, int B, int weight) {
        this.adyacentList.get(A).add(new Node(B, weight));
        this.adyacentList.get(B).add(new Node(A, weight));
    }

    public int bfs(int start, int end) {
        boolean[] visited = new boolean[this.size + 1];

        return -1;
    }

}

public class p504 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        Graph graph;
        boolean found, flag;
        int N, C;
        int distance[];
        int start, end, querys, bestWeight, streets;
        State current;

        while (s.hasNext()) {

            N = s.nextInt();
            C = s.nextInt();

            graph = new Graph(N);

            for (int i = 0; i < C; i++) {
                graph.addPair(s.nextInt(), s.nextInt(), s.nextInt());
            }

            querys = s.nextInt();
            for (int i = 0; i < querys; i++) {

                start = s.nextInt(); end = s.nextInt();
                found = flag = false;
                PriorityQueue<State> q = new PriorityQueue<>();
                distance = new int[N + 1];
                for (int j = 1; j <= N; j++) distance[j] = Integer.MAX_VALUE;
                bestWeight = -1;
                streets = -1;

                q.add(new State(start, 0, 0));
                distance[start] = 0;

                while (!q.isEmpty()) {

                    current = q.poll();

                    if (current.weight > distance[current.node]) continue;
                    if (current.node == end) {
                        bestWeight = current.weight;
                        found = true;
                    }

                    for (Node node : graph.adyacentList.get(current.node)) {

                        int weight = node.weight + current.weight;
                        if (weight > distance[node.to]) continue;
                        distance[node.to] = weight;
                        q.add(new State(node.to, current.streets + 1, weight));

                    }

                }

                if (!found) {
                    System.out.println("SIN CAMINO");
                }
                else {
                    System.out.println(bestWeight + " NO");
                }

            }

            System.out.println("---");
        }

    }

}
