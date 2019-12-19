import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class Graph {

    HashMap<Integer, LinkedList<Integer>> adyacent;

    public Graph(int nodes) {
        adyacent = new HashMap<>();
        for (int i = 1; i <= nodes; i++) {
             adyacent.put(Integer.valueOf(i), new LinkedList<>());
        }
    }

    void addEdge(int node, int value) {
        adyacent.get(node).add(value);
    }

    LinkedList<Integer> getAdyacentList(int node) {
        return this.adyacent.get(node);
    }

}

public class p537B {

    static void dfs(Graph graph, int node, boolean[] visited) {
        visited[node] = true;
        LinkedList<Integer> list = graph.getAdyacentList(node);
        for (Integer n : list) {
            if (!visited[n]) {
                dfs(graph, n, visited);
            }
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int P, C, A, B;
        Graph graph;
        boolean[] visited;

        while (s.hasNext()) {

            P = s.nextInt();
            C = s.nextInt();

            graph = new Graph(P);

            for (int i = 0; i < C; i++) {
                A = s.nextInt();
                B = s.nextInt();
                graph.addEdge(A, B);
                graph.addEdge(B, A);
            }

            visited = new boolean[P + 1];
            dfs(graph, 1, visited);

            boolean bici = true;
            for (int i = 1; i <= P && bici; i++) {
                bici = visited[i];
            }

            System.out.println( bici ? "BICI" : "A PIE" );
        }

    }

}
