import java.util.*;

class S implements Comparable<S> {
    int node, weight;
    public S(int f, int w) {
        this.node = f;
        this.weight = w;
    }

    @Override
    public int compareTo(S s) {
        return this.weight - s.weight;
    }
}

public class p253 {

    static int minSteps(int target, HashMap<Integer, Integer> connections, boolean[] vis, int K, int N) {

        PriorityQueue<S> q = new PriorityQueue<>();
        q.add(new S(1, 0));

        while (!q.isEmpty()) {
            S current = q.poll();
            for (int i = K; i >= 1; i--) {
                if ((current.node + i) <= (N * N) && !vis[connections.get(current.node + i)]) {
                    int dest = connections.get(current.node + i);
                    vis[dest] = true;
                    if (dest == target)
                        return current.weight + 1;
                    q.add(new S(dest, current.weight + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int S, E, K, N;
        HashMap<Integer, Integer> connections = new HashMap<>();
        boolean[] vis = new boolean[10001];

        while (true) {
            N = s.nextInt();
            K = s.nextInt();
            S = s.nextInt();
            E = s.nextInt();

            if (N == 0 && K == 0 && S == 0 && E == 0)
                break;

            Arrays.fill(vis, false);
            for (int i = 1; i <= N * N; i++)
                connections.put(i, i);

            for (int i = 0; i < S + E; i++)
                connections.put(s.nextInt(), s.nextInt());

            System.out.println( minSteps(N * N, connections, vis, K, N) );
            connections.clear();
        }

    }

}
