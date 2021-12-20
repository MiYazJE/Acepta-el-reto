import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p600 {

    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int f, c;
        int[][] m;
        int[][] cols, rows;
        boolean valid;
        String[] line;

        while (true) {
            line = br.readLine().split(" ");
            f = Integer.parseInt(line[0]);
            c = Integer.parseInt(line[1]);
            if (f == 0 && c == 0) break;

            m    = new int[f][c];
            rows = new int[f][2];
            cols = new int[c][2];

            for (int i = 0; i < Math.max(f, c); i++) {
                if (i < f) {
                    rows[i][0] = Integer.MAX_VALUE;
                    rows[i][1] = Integer.MIN_VALUE;
                }
                if (i < c) {
                    cols[i][0] = Integer.MAX_VALUE;
                    cols[i][1] = Integer.MIN_VALUE;
                }
            }

            for (int i = 0; i < f; i++) {
                int minF = rows[i][0], maxF = rows[i][1];
                line = br.readLine().split(" ");
                for (int j = 0; j < c; j++) {
                    int num = Integer.parseInt(line[j]);
                    m[i][j] = num;
                    minF = Math.min(minF, num);
                    maxF = Math.max(maxF, num);
                    cols[j][0] = Math.min(cols[j][0], num);
                    cols[j][1] = Math.max(cols[j][1], num);
                }
                rows[i][0] = minF;
                rows[i][1] = maxF;
            }

            valid = false;
            for (int i = 0; i < f && !valid; i++) {
                for (int j = 0; j < c && !valid; j++) {
                    int current = m[i][j];
                    valid = (rows[i][0] == current && cols[j][1] == current) ||
                            (rows[i][1] == current && cols[j][0] == current);
                }
            }

            System.out.println(valid ? "SI" : "NO");
        }

    }

}
