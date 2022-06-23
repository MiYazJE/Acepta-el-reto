import java.util.*;

class Graph {
    private int N;
    private int[] adj;
    private int visited[];

    Graph(int N) {
        this.N = N;
        this.visited = new int[N + 1];
        this.adj = new int[N + 1];
    }

    void addEdge(int from, int to) {
        this.adj[from] = to;
    }
    
    void clear(int to) {
        Arrays.fill(this.visited, 0, to + 1, 0);
        Arrays.fill(this.adj, 0, to + 1, 0);
    }

    boolean hasCycleFrom(int current, int id) {
        if (visited[current] != 0 && visited[current] != id) return false;
        if (visited[current] == id) return true;

        visited[current] = id;
        
        if (this.adj[current] != 0) {
            return hasCycleFrom(this.adj[current], id);
        }

        return false;
    }

    int getCycles(int to) {
        int cycles = 0, id = 1;
        for (int i = 1; i <= to; i++) {
            if (this.hasCycleFrom(i, id)) cycles++;
            id++;
        }
        return cycles;
    }

}

public class p642 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N;
        Graph graph = new Graph(10000);

        while (s.hasNext()) {
            N = s.nextInt();

            for (int from = 1; from <= N; from++) {
                int to = s.nextInt();
                graph.addEdge(from, to);
            }

            System.out.println(graph.getCycles(N));
            graph.clear(N);
        }

    }

}
