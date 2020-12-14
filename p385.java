import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Cell implements Comparable<Cell> {
    int f, c, weight;

    public Cell(int f, int c) {
        this.f = f;
        this.c = c;
    }

    public Cell(int f, int c, int weight) {
        this.f = f;
        this.c = c;
        this.weight = weight;
    }

    public int compareTo(Cell cell) {
        return this.weight - cell.weight;
    }
}

public class p385 {

    static int[] exploreF = new int[]{0, 0, 1, -1};
    static int[] exploreC = new int[]{1, -1, 0, 0};

    static int bfs(char[][] m, int startI, int startJ, int endI, int endJ, int F, int C) {
        if (m[startI][startJ] == '*' || m[endI][endJ] == '*') return -1;
        boolean visited[][] = new boolean[F][C];
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.add(new Cell(startI, startJ, 0));

        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            if (m[current.f][current.c] == 'P') return current.weight;
            if (visited[current.f][current.c]) continue;
            visited[current.f][current.c] = true;

            for (int i = 0; i < 4; i++) {
                int newF = current.f + exploreF[i];
                int newC = current.c + exploreC[i];
                if (newF == -1 || newF == F || newC == -1 || newC == C || visited[newF][newC])
                    continue;
                if (m[newF][newC] == '.' || m[newF][newC] == 'P') {
                    pq.add(new Cell(newF, newC, current.weight + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        char[][] m;
        ArrayList<Cell> exploreCells = new ArrayList<>();
        int cases = s.nextInt(), F, C, endX = 0, endY = 0, iniY = 0, iniX = 0;

        while (cases-- != 0) {
            C = s.nextInt();
            F = s.nextInt();
            m = new char[F][C];

            for (int i = 0; i < F; i++) {
                String line = s.next();
                for (int j = 0; j < C; j++) {
                    char c = line.charAt(j);
                    m[i][j] = c;
                    if (c == 'E') { iniX = j; iniY = i; }
                    else if (c == 'P') { endX = j; endY = i; }
                    else if (Character.isDigit(c)) exploreCells.add(new Cell(i, j));
                }
            }

            for (Cell explore : exploreCells) {
                int i = explore.f;
                int j = explore.c;
                int num = Integer.parseInt("" + m[i][j]);
                for (int k = 1; k <= num; k++) { // top
                    if (i - k < 0 || m[i - k][j] == '#') break;
                    if (!Character.isDigit(m[i - k][j])) m[i - k][j] = '*';
                }
                for (int k = 1; k <= num; k++) { // bottom
                    if (i + k == F || m[i + k][j] == '#') break;
                    if (!Character.isDigit(m[i + k][j])) m[i + k][j] = '*';
                }
                for (int k = 1; k <= num; k++) { // left
                    if (j - k < 0 || m[i][j - k] == '#') break;
                    if (!Character.isDigit(m[i][j - k])) m[i][j - k] = '*';
                }
                for (int k = 1; k <= num; k++) { // right
                    if (j + k == C || m[i][j + k] == '#') break;
                    if (!Character.isDigit(m[i][j + k])) m[i][j + k] = '*';
                }
            }

            int bestWeight = bfs(m, iniY, iniX, endY, endX, F, C);
            System.out.println( bestWeight == -1 ? "NO" : bestWeight );
            exploreCells.clear();
        }

    }

}
