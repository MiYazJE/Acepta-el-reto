import java.util.*;

public class p288 {

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
                sizes[rootA] += rankB;
            }
            else {
                uf[rootA] = rootB;
                sizes[rootB] += rankA;
            }
        }
        maxSize = Math.max(maxSize, Math.max(sizes[rootB], sizes[rootA]));
    }

    static int find(int n) {
        if (n == uf[n]) return n;
        uf[n] = find(uf[n]);
        return uf[n];
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        boolean[][] m;
        int F, C, c, index, y, x;
        StringBuilder sequence = new StringBuilder();;

        while (s.hasNext()) {

            F = s.nextInt();
            C = s.nextInt();
            s.nextLine();

            m = new boolean[F + 2][C + 2];
            sizes = new int[F * C + 1];
            uf = new int[F * C + 1];

            for (int i = 1; i <= F * C; i++) {
                uf[i] = i;
                sizes[i] = 1;
            }

            for (int i = 1; i <= F; i++) {
                String line = s.nextLine();
                for (int j = 1; j <= line.length(); j++)
                    m[i][j] = line.charAt(j - 1) == '#';
            }

            maxSize = 0;
            for (int i = 1; i <= F; i++) {
                for (int j = 1; j <= C; j++) {
                    if (!m[i][j]) continue;
                    maxSize = Math.max(maxSize, 1);
                    index = ((i - 1) * C) + j;

                    if (m[i + 1][j]) union(index, index + C); // top
                    if (m[i - 1][j]) union(index, index - C); // bottom
                    if (m[i][j - 1]) union(index, index - 1); // left
                    if (m[i][j + 1]) union(index, index + 1); // right

                    if (m[i + 1][j - 1]) union(index, index + C - 1); // corner bottom left
                    if (m[i + 1][j + 1]) union(index, index + C + 1); // corner bottom right
                    if (m[i - 1][j - 1]) union(index, index - C - 1); // corner top left
                    if (m[i - 1][j + 1]) union(index, index - C + 1); // corner top right
                }
            }

            sequence.append(maxSize);

            c = s.nextInt();
            while (c-- != 0) {
                y = s.nextInt();
                x = s.nextInt();
                maxSize = Math.max(maxSize, 1);
                m[y][x] = true;
                index = ((y - 1) * C ) + x;

                if (m[y + 1][x]) union(index, index + C); // top
                if (m[y - 1][x]) union(index, index - C); // bottom
                if (m[y][x - 1]) union(index, index - 1); // left
                if (m[y][x + 1]) union(index, index + 1); // right

                if (m[y + 1][x - 1]) union(index, index + C - 1); // corner bottom left
                if (m[y + 1][x + 1]) union(index, index + C + 1); // corner bottom right
                if (m[y - 1][x - 1]) union(index, index - C - 1); // corner top left
                if (m[y - 1][x + 1]) union(index, index - C + 1); // corner top right

                sequence.append(" ").append(maxSize);
            }

            System.out.println(sequence.toString());
            sequence.delete(0, sequence.length());
        }

    }

}
