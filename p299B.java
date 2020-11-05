import java.util.*;

class Pair {
    int from, to, weight;
    public Pair(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

class SortPairs implements Comparator<Pair> {
    @Override
    public int compare(Pair pair, Pair t1) {
        return pair.weight - t1.weight;
    }
}

public class p299B {

    static int[] uf;
    static int[] ranks;
    static int[] sizes;

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            int rankA = ranks[rootA];
            int rankB = ranks[rootB];
            if (rankA >= rankB) {
                ranks[rootA] = rankA == rankB ? rankA + 1 : rankA;
                uf[rootB] = rootA;
                sizes[rootA] += sizes[rootB];
            }
            else {
                uf[rootA] = rootB;
                sizes[rootB] += sizes[rootA];
            }
            return true;
        }
        return false;
    }

    static int find(int n) {
        if (n == uf[n]) return n;
        uf[n] = find(uf[n]);
        return uf[n];
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        LinkedList<Pair> pairs = new LinkedList<>();
        SortPairs sort = new SortPairs();
        boolean valid;
        int N, C, min;

        while (s.hasNext()) {

            N = s.nextInt();
            C = s.nextInt();

            sizes = new int[N + 1];
            ranks = new int[N + 1];
            uf = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                uf[i] = i;
                sizes[i] = 1;
            }

            for (int i = 0; i < C; i++)
                pairs.add(new Pair(s.nextInt(), s.nextInt(), s.nextInt()));

            Collections.sort(pairs, sort);

            min = 0;
            for (Pair edge : pairs)
                if (union(edge.from, edge.to))
                    min += edge.weight;

            valid = false;
            for (int i = 1; i < sizes.length && !valid; i++)
                valid = sizes[i] == N;

            System.out.println( valid ? min : "Imposible" );
            pairs.clear();
        }

    }

}
