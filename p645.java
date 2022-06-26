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

public class p645 {

    static int[] uf;
    static int[] ranks;
    static int[] sizes;

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;

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
        sizes = new int[10_001];
        ranks = new int[10_001];
        uf = new int[10_001];

        while (s.hasNext()) {

            N = s.nextInt();
            C = s.nextInt();

            for (int i = 1; i <= N; i++) {
                uf[i] = i;
                sizes[i] = 1;
                ranks[i] = 0;
            }

            for (int i = 0; i < C; i++)
                pairs.add(new Pair(s.nextInt(), s.nextInt(), s.nextInt()));

            Collections.sort(pairs, sort);

            min = 0;
            for (Pair edge : pairs)
                if (union(edge.from, edge.to)) {
                    min += edge.weight;
                }

            valid = false;
            for (int i = 1; i < sizes.length && !valid; i++)
                valid = sizes[i] == N;

            System.out.println( valid ? min : "No hay puentes suficientes" );
            pairs.clear();
        }

    }

}
