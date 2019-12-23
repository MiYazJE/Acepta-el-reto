package p453;

import java.util.*;

/**
 * @author Rubén Saiz
 */

class Graph {

    int N;
    HashMap<Integer, LinkedList<Integer>> adyacentList;

    public Graph(int N) {
        this.N = N;
        adyacentList = new HashMap<>();
        for (Integer i = 1; i <= N; i++) {
            adyacentList.put(i, new LinkedList<Integer>());
        }
    }

    void addEdge(int node, int v) {
        this.adyacentList.get(node).add(v);
        this.adyacentList.get(v).add(node);
    }

    void bfs(int x, boolean[] visited) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = this.adyacentList.get(queue.poll());
            for (Integer n : list) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void dfs(int x, boolean[] visited) {
        visited[x] = true;
        LinkedList<Integer> list = this.adyacentList.get(x);
        for (Integer n : list) {
            if (!visited[n]) {
                visited[n] = true;
                dfs(n, visited);
            }
        }
    }

}

public class p453 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int relaciones, especies;
        Graph graph = new Graph(10_001);
        boolean valid;
        boolean[] visited = new boolean[10_001];

        while (true) {

            especies = s.nextInt();
            if (especies == 0) break;
            relaciones = s.nextInt();

            for (int i = 1; i <= especies; i++) {
                if (graph.adyacentList.get(i) != null)
                    graph.adyacentList.get(i).clear();
                visited[i] = false;
            }

            for (int i = 0; i < relaciones; i++) {
                graph.addEdge(s.nextInt(), s.nextInt());
            }

            graph.bfs(1, visited);
            valid = true;
            for (int i = 1; i <= especies && valid; i++) valid = visited[i];

            System.out.println( (valid) ? "TODAS" : "FALTA ALGUNA" );
        }

    }

}
