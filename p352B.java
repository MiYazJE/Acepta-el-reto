import java.util.*;

public class p352B {

    static int[] uf;
    static int[] sizes;
    static int maxSize;

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            int rankA = sizes[rootA];
            int rankB = sizes[rootB];

            if (rankA >= rankB) {
                uf[rootB] = rootA;
                rankA += rankB;
                sizes[rootA] = rankA;
            } else {
                uf[rootA] = rootB;
                rankB += rankA;
                sizes[rootB] = rankB;
            }

            maxSize = Math.max(maxSize, Math.max(rankA, rankB));
        }
    }

    static int find(int n) {
        if (n == uf[n]) return n;
        uf[n] = find(uf[n]);
        return uf[n];
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int N, C, A, B, cases = s.nextInt();

        while (cases-- != 0) {

            N = s.nextInt();
            C = s.nextInt();

            maxSize = 1;
            sizes = new int[N + 1];
            uf = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                uf[i] = i;
                sizes[i] = 1;
            }

            for (int i = 0; i < C; i++) {
                A = s.nextInt();
                B = s.nextInt();
                union(A, B);
            }

            System.out.println(maxSize);
        }

    }

}
