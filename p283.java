import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p283 {

    static int temp;
    static int[] dirF = {1, 0, -1, 0};
    static int[] dirC = {0, 1, 0, -1};
    
    public static void dfs(int[][] grid, int f, int c, boolean[][] visited) {
        if (f < 0 || c < 0 || f == grid.length || c == grid[0].length || visited[f][c] || grid[f][c] == 0) {
            return;
        }
        temp++;
        visited[f][c] = true;
        int newF, newC;
        for (int i = 0; i < 4; i++) {
            newF = f + dirF[i];
            newC = c + dirC[i];
            dfs(grid, newF, newC, visited);
        }
    }
    
    public static int maxPlot(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxPlot = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    temp = 0;
                    dfs(grid, i, j, visited);
                    maxPlot = Math.max(maxPlot, temp);
                }
            }
        }
        return maxPlot;
    }

    public static void main(String[] args) throws IOException {

        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int f, c;
        int[][] m;
        String input;
        String[] inputs;

        while (true) {

            input = reader.readLine();
            if (input == null) break;
            inputs = input.split(" ");

            f = Integer.parseInt(inputs[0]);
            c = Integer.parseInt(inputs[1]);
            m = new int[f][c];

            for (int i = 0; i < f; i++) {
                String line = reader.readLine();
                for (int j = 0; j < c; j++) {
                    m[i][j] = line.charAt(j) == '#' ? 1: 0;
                }
            }

            System.out.println(maxPlot(m));
        }

    }

}
