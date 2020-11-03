import java.util.*;

class State implements Comparable<State> {

    Character node;
    int weight;

    public State(Character node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(State state) {
        return this.weight - state.weight;
    }
}

class Graph {

    HashMap<Character, HashSet<Character>> adj;

    public Graph() {
        adj = new HashMap<>();
    }

    public void addEdge(Character A, Character B) {
        if (!this.adj.containsKey(A)) {
            this.adj.put(A, new HashSet<Character>());
        }
        if (A != B) {
            this.adj.get(A).add(B);
        }
    }

    public void clear() {
        this.adj.clear();
    }

    public void dijkstra(Character start, HashMap<Character, Integer> weights) {
        Queue<State> q = new PriorityQueue<>();
        q.add(new State(start, 0));
        weights.put(start, 0);

        while (!q.isEmpty()) {
            State current = q.poll();

            if (weights.get(current.node) < current.weight)
                continue;

            for (Character explore : this.adj.get(current.node)) {
                int newWeight = current.weight + 1;
                if (weights.get(explore) >= newWeight) {
                    weights.put(explore, newWeight);
                    q.add(new State(explore, newWeight));
                }
            }
        }
    }

}

public class p563 {

    static int[] getCordinates(char[][] m, char current, int i, int j, int sumI, int sumJ) {
        if (i + sumI == -1 ||
            j + sumJ == -1 ||
            i + sumI == m.length ||
            j + sumJ == m[0].length ||
            m[i][j] != current)
            return new int[] {i, j};
        return getCordinates(m, current, i + sumI, j + sumJ, sumI, sumJ);
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Graph graph = new Graph();
        HashSet<Character> visitedKeys = new HashSet<>();
        HashMap<Character, HashMap<Character, Integer>> weights = new HashMap<>();
        char[][] m;
        int R, C, N, ans;
        String line;
        char A, B;

        while (true) {

            R = s.nextInt();
            C = s.nextInt();
            N = s.nextInt();

            if (R == 0 && C == 0 && N == 0)
                break;

            m = new char[R][C];
            for (int i = 0; i < R; i++) {
                line = s.next();
                for (int j = 0; j < C; j++) {
                    m[i][j] = line.charAt(j);
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    char currentKey = m[i][j];
                    if (!visitedKeys.contains(currentKey)) {
                        if (i == 0) {
                            graph.addEdge(currentKey, m[m.length - 1][j]);
                        }
                        else {
                            int[] top = getCordinates(m, currentKey, i, j, -1, 0);
                            if (top[0] == 0 && currentKey == m[0][j])
                                graph.addEdge(currentKey, m[R - 1][j]);
                            else
                                graph.addEdge(currentKey, m[top[0]][j]);
                        }

                        if (i == m.length - 1) {
                            graph.addEdge(currentKey, m[0][j]);
                        }
                        else {
                            int[] bottom = getCordinates(m, currentKey, i, j, 1, 0);
                            if (bottom[0] == R - 1 && currentKey == m[R - 1][j])
                                graph.addEdge(currentKey, m[0][j]);
                            else
                                graph.addEdge(currentKey, m[bottom[0]][j]);
                        }

                        if (j == 0) {
                            graph.addEdge(currentKey, m[i][m[0].length - 1]);
                        }
                        else {
                            int[] left = getCordinates(m, currentKey, i, j, 0, -1);
                            if (left[1] == 0 && currentKey == m[i][0])
                                graph.addEdge(currentKey, m[i][C - 1]);
                            else
                                graph.addEdge(currentKey, m[i][left[1]]);
                        }

                        if (j == C - 1) {
                            graph.addEdge(currentKey, m[i][0]);
                        }
                        else {
                            int[] right = getCordinates(m, currentKey, i, j, 0, 1);
                            if (right[1] == C - 1 && currentKey == m[i][C - 1])
                                graph.addEdge(currentKey, m[i][0]);
                            else
                                graph.addEdge(currentKey, m[i][right[1]]);
                        }

                        visitedKeys.add(currentKey);
                    }
                }
            }

            HashMap<Character, Integer> infinityWeights = new HashMap<>();
            for (Character key : visitedKeys)
                infinityWeights.put(key, Integer.MAX_VALUE);

            for (Character key : visitedKeys) {
                HashMap<Character, Integer> weight = new HashMap<>();
                for (Map.Entry<Character, Integer> e : infinityWeights.entrySet())
                    weight.put(e.getKey(), e.getValue());
                weights.put(key, weight);
                graph.dijkstra(key, weight);
            }

            while (N-- != 0) {
                line = s.next();
                ans = weights.get(m[0][0]).get(line.charAt(0));

                for (int i = 1; i < line.length(); i++) {
                    A = line.charAt(i - 1);
                    B = line.charAt(i);
                    ans += weights.get(A).get(B);
                }

                System.out.println( ans );
            }

            System.out.println( "---" );
            graph.clear();
            visitedKeys.clear();
            weights.clear();
        }

    }

}
