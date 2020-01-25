import java.util.*;

/**
 * @author Rubén Saiz
 */

class Graph {

    HashMap<Integer, LinkedList<Integer>> adyacentList;
    int size;

    public Graph(int size) {

        this.size = size;
        adyacentList = new HashMap<>();

        for (int i = 0; i < this.size; i++) {
            adyacentList.put(i, new LinkedList<Integer>());
        }
    }

    public void addPair(int A, int B) {
        this.adyacentList.get(A).addLast(B);
        this.adyacentList.get(B).addLast(A);
    }

    public boolean isCyclicConntected(int s, int V, boolean visited[]) {

        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {

            int u = q.poll();

            for (Integer v : this.adyacentList.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    parent[v] = u;
                } else if (parent[u] != v)
                    return true;
            }

        }

        return false;
    }

    public boolean isCyclicDisconntected(int V) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i] && isCyclicConntected(i, V, visited))
                return true;

        return false;
    }

    public void bfs(int i, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while (!q.isEmpty()) {
            int u = q.poll();
            visited[u] = true;
            for (Integer c : this.adyacentList.get(u)) {
                if (!visited[c]) q.add(c);
            }
        }

    }

    public void clear(int to) {
        for (int i = 0; i < to; i++) {
            this.adyacentList.get(i).clear();
        }
    }

}

public class p307 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N, V;
        Graph graph = new Graph(10_001);
        boolean[] visited;
        boolean connected;

        while (s.hasNext()) {

            N = s.nextInt();
            V = s.nextInt();

            for (int i = 0; i < V; i++)
                graph.addPair(s.nextInt(), s.nextInt());

            visited = new boolean[N];
            if (!graph.isCyclicDisconntected(N)) {
                graph.bfs(0, visited);
                connected = true;
                for (int i = 0; i < N && connected; i++)
                    connected = visited[i];
                System.out.println( (connected) ? "SI" : "NO" );
            }
            else {
                System.out.println("NO");
            }

            graph.clear(N);
        }

    }

}
