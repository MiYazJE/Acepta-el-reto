import java.util.*;

public class p432 {

    static void dfs(char[][] m, int i, int j) {
        if (i < m.length && i >= 0 && j >= 0 && j < m[0].length) {
            if (m[i][j] == 'F') transitable = true;
            else if (m[i][j] == '.') {
                if (m[i][j] == '.') m[i][j] = 'x';
                dfs(m, i+1, j);
                dfs(m, i, j+1);
                dfs(m, i-1, j);
                dfs(m, i, j-1);
            }
        }
    }

    static boolean transitable;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int f, c, iniX = 0, iniY = 0;
        char[][] m;
        String linea;

        while (s.hasNext()) {

            f = s.nextInt();
            c = s.nextInt();

            m = new char[f][c];

            for (int i = 0; i < f; i++) {
                linea = s.next();
                for (int j = 0; j < c; j++) {
                    if (linea.charAt(j) == 'S') {
                        iniX = i;
                        iniY = j;
                        m[i][j] = '.';
                    }
                    else m[i][j] = linea.charAt(j);
                }
            }


            transitable = false;
            dfs(m, iniX, iniY);

            System.out.println(transitable ? "SI" : "NO");
        }

    }

}
