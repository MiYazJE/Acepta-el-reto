import java.util.*;

/*
    Tarjan's algorithm
 */

class Graph {
    private int N;
    private HashMap<Integer, LinkedList<Integer>> adj;
    private int maxGroup;
    private int[] low;
    private int[] ids;
    private boolean[] visited;
    private boolean[] onStack;
    private Stack<Integer> stack;
    private int id;

    Graph(int N) {
        this.N = N;
        this.maxGroup = 1;
        this.low = new int[N + 1];
        this.onStack = new boolean[N + 1];
        this.visited = new boolean[N + 1];
        this.ids = new int[N + 1];
        this.stack = new Stack<>();

        this.adj = new HashMap<>();
        for (int i = 1; i <= this.N; ++i)
            this.adj.put(i, new LinkedList<Integer>());
    }

    void addEdge(int from, int to) {
        this.adj.get(from).add(to);
    }

    void clear(int to) {
        for (int i = 1; i <= to; i++) {
            adj.get(i).clear();
            visited[i] = false;
        }
        stack.clear();
    }

    int getMaxSCC() {
        Arrays.fill(low, -1);
        this.maxGroup = 1;
        this.id = 0;

        for (Map.Entry<Integer, LinkedList<Integer>> e : adj.entrySet())
            if (low[e.getKey()] == -1)
                this.dfs(e.getKey());

        return this.maxGroup;
    }

    void dfs(int current) {
        stack.add(current);
        onStack[current] = true;
        ids[current] = low[current] = id++;

        for (int explore : adj.get(current)) {
            if (low[explore] == -1) dfs(explore);
            if (onStack[explore])
                low[current] = Math.min(low[current], low[explore]);
        }

        if (low[current] == ids[current]) {
            int temp = 0, node = -1;
            while (node != current) {
                node = stack.pop();
                onStack[node] = false;
                temp++;
            }
            this.maxGroup = Math.max(this.maxGroup, temp);
        }

    }

}

public class p575 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Graph graph = new Graph(1001);
        int N, C, from;

        while (s.hasNext()) {
            N = s.nextInt();

            while (true) {
                from = s.nextInt();
                if (from == 0) break;

                C = s.nextInt();
                while (C-- != 0)
                    graph.addEdge(from, s.nextInt());
            }

            System.out.println( graph.getMaxSCC() );
            graph.clear(N);
        }

    }

}
