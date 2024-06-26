import java.util.Scanner;

public class p747 {

  static boolean can(char[][] m, int i, int j) {
    if (i < 0 || i == m.length || j < 0 || j == m[i].length || m[i][j] == 'X') {
      return false;
    }

    if (i == m.length - 1 && j == m[i].length - 1 && m[i][j] == '.') {
      return true;
    }

    m[i][j] = 'X';

    return can(m, i + 1, j) ||
        can(m, i - 1, j) ||
        can(m, i, j + 1) ||
        can(m, i, j - 1);
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    char[][] m;

    while (true) {
      int F = s.nextInt();
      int C = s.nextInt();
      if (F == 0 && C == 0)
        break;

      s.nextLine();
      m = new char[F][C];

      for (int i = 0; i < F; i++) {
        char[] arr = s.nextLine().toCharArray();
        for (int j = 0; j < C; j++) {
          m[i][j] = arr[j];
        }
      }

      System.out.println(can(m, 0, 0) ? "SI" : "NO");
    }

    s.close();
  }

}
