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
        for (Integer i = 0; i < N; i++) {
            adyacentList.put(i, new LinkedList<Integer>());
        }
    }

    void addEdge(int node, int v) {
        this.adyacentList.get(node).add(v);
        this.adyacentList.get(v).add(node);
    }

    private LinkedList<Integer> getAdyacentList(int node) {
        return this.adyacentList.get(node);
    }

    boolean isBipartite() {

        HashMap<Integer, String> colors = new HashMap<>();
        boolean[] visited = new boolean[this.N + 1];
        LinkedList<Integer> q = new LinkedList<>();

        for (Map.Entry<Integer, LinkedList<Integer>> entry : this.adyacentList.entrySet()) {

            if (!visited[entry.getKey()]) {

                visited[entry.getKey()] = true;
                q.add(entry.getKey());
                colors.put(entry.getKey(), "red");

                while (!q.isEmpty()) {

                    int currentNode = q.poll();
                    String currentColor = colors.get(currentNode);
                    String colorAdd = currentColor.equals("red") ? "blue" : "red";

                    for (Integer n : this.getAdyacentList(currentNode)) {
                        if (!visited[n]) {
                            q.add(n);
                            colors.put(n, colorAdd);
                            visited[n] = true;
                        } else {
                            if (currentColor.equals(colors.get(n)))
                                return false;
                        }
                    }

                }
            }

        }

        return true;
    }

}

public class p279 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int N, V, A, B;
        Graph graph;

        while (s.hasNext()) {

            N = s.nextInt();
            graph = new Graph(N);

            V = s.nextInt();
            for (int i = 0; i < V; i++) {
                A = s.nextInt();
                B = s.nextInt();
                graph.addEdge(A, B);
            }

            System.out.println( graph.isBipartite() ? "SI" : "NO" );
        }

    }

}
