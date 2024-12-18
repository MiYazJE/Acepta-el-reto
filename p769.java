import java.util.Scanner;

public class p769 {

  static void dfs(char[][] m, int i, int j) {
    if (i < 0 || i == m.length || j < 0 || j == m[i].length || m[i][j] != '#') {
      return;
    }

    m[i][j] = '.';

    dfs(m, i + 1, j);
    dfs(m, i - 1, j);
    dfs(m, i, j + 1);
    dfs(m, i, j - 1);
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (s.hasNext()) {
      int F = s.nextInt();
      int C = s.nextInt();
      char[][] m = new char[F][C];

      s.nextLine();
      for (int i = 0; i < F; i++) {
        char[] str = s.nextLine().toCharArray();
        for (int j = 0; j < C; j++) {
          m[i][j] = str[j];
        }
      }

      int ans = 0;
      for (int i = 0; i < F; i++) {
        for (int j = 0; j < C; j++) {
          if (m[i][j] == '#') {
            ans++;
            dfs(m, i, j);
          }
        }
      }

      System.out.println(ans);
    }

    s.close();

  }

}
