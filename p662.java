import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    int weight;
    int f, c;

    Node(int f, int c, int weight) {
        this.f = f;
        this.c = c;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node node) {
        return this.weight - node.weight;
    }
}
public class p662 {

    static int[] exploreC = new int[]{1, 0, -1, 0};
    static int[] exploreF = new int[]{0, 1, 0, -1};

    static int[] getMin(int startF, int startC, int minCells, int[][] m) {
        int max = m[startF][startC];
        int many = 0;

        boolean[][] visited = new boolean[m.length][m[0].length];
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.add(new Node(startF, startC, 0));

        while (!q.isEmpty()) {
            Node current = q.poll();
            if (many >= minCells && current.weight > max) break;
            if (visited[current.f][current.c]) continue;

            many++;
            max = Math.max(max, current.weight);
            visited[current.f][current.c] = true;

            for (int i = 0; i < 4; i++) {
                int newF = exploreF[i] + current.f;
                int newC = exploreC[i] + current.c;
                if (newF < 0 || newF == m.length ||
                   newC < 0 || newC == m[0].length ||
                    visited[newF][newC]
                ) continue;
                q.add(new Node(newF, newC, m[newF][newC]));
            }
        }

        return new int[]{max, many};
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int C, F;
        int[][] m;

        while (s.hasNext()) {
            C = s.nextInt();
            F = s.nextInt();

            m = new int[F][C];
            for (int i = 0; i < F; i++)
                for (int j = 0; j < C; j++)
                    m[i][j] = s.nextInt();

            int startC = 0;
            int startF = F / 2;

            int minCells = (C * F) / 2 + 1;
            int[] res = getMin(startF, startC, minCells, m);

            System.out.println(res[0] + " " + res[1]);
        }

    }

}
