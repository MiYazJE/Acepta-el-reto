import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Cell implements Comparable<Cell> {
    int f, c, weight, direction;
    public Cell(int f, int c, int weight) {
        this.f = f;
        this.c = c;
        this.weight = weight;
    }
    public Cell(int f, int c, int weight, int direction) {
        this.f = f;
        this.c = c;
        this.weight = weight;
        this.direction = direction;
    }
    @Override
    public int compareTo(Cell cell) {
        return this.weight - cell.weight;
    }
}

public class p594 {

    static int[] exploreF  = new int[]{0, -1, 0, 1};
    static int[] exploreC  = new int[]{1, 0, -1, 0};
    static int[] translate = new int[]{3, 0, 1, 2};

    static boolean isSafe(char[][] m, int f, int c) {
        return f > 0 && f < m.length && c > 0 && c < m[0].length && m[f][c] != '#';
    }

    static int customBfs(char[][] m, int startF, int startC) {
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(startF, startC, 0));
        boolean[][][] visited = new boolean[m.length][m[0].length][4];

        while (!q.isEmpty()) {
            Cell current = q.poll();

            if (m[current.f][current.c] == 'T') {
                return current.weight;
            }
            if (visited[current.f][current.c][current.direction]) continue;
            visited[current.f][current.c][current.direction] = true;

            for (int i = current.direction; i < 4 + current.direction; i++) {
                int newDirection = i % 4;
                int newF = current.f + exploreF[newDirection];
                int newC = current.c + exploreC[newDirection];
                if (isSafe(m, newF, newC) && !visited[newF][newC][translate[newDirection]]) {
                    q.add(new Cell(newF, newC, current.weight + 1, translate[newDirection]));
                    break;
                }
            }
        }

        return -1;
    }

    static int bfs(char[][] m, int startF, int startC) {
        PriorityQueue<Cell> q = new PriorityQueue<>();
        q.add(new Cell(startF, startC, 0));
        boolean[][] visited = new boolean[m.length][m[0].length];

        while (!q.isEmpty()) {
            Cell current = q.poll();

            if (m[current.f][current.c] == 'T') {
                return current.weight;
            }
            if (visited[current.f][current.c]) continue;
            visited[current.f][current.c] = true;

            for (int i = 0; i < 4; i++) {
                int newF = current.f + exploreF[i];
                int newC = current.c + exploreC[i];
                if (isSafe(m, newF, newC) && !visited[newF][newC]) {
                    q.add(new Cell(newF, newC, current.weight + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int f, c, startF, startC;
        char[][] m;

        while (s.hasNext()) {
            c = s.nextInt();
            f = s.nextInt();
            m = new char[f][c];
            startC = startF = 0;
            for (int i = 0; i < f; i++) {
                String line = s.next();
                for (int j = 0; j < c; j++) {
                    m[i][j] = line.charAt(j);
                    if (i == f -1 && line.charAt(j) == '.') {
                        startF = i;
                        startC = j;
                    }
                }
            }
            int best = bfs(m, startF, startC);
            if (best == -1) System.out.println("IMPOSIBLE");
            else {
                int costCustomBfs = customBfs(m, startF, startC);
                if (costCustomBfs == -1) System.out.println("INF");
                else if (costCustomBfs == best) System.out.println("IGUAL");
                else System.out.println(costCustomBfs - best);
            }
        }

    }

}
