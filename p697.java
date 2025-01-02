import java.util.Scanner;

public class p697 {

  static int[] directionsY = new int[] { -1, 0, 1, 0 };
  static int[] directionsX = new int[] { 0, 1, 0, -1 };

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    int N;
    int[][] m;

    while (true) {
      N = s.nextInt();
      if (N == 0)
        break;

      m = new int[N][N];

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          m[i][j] = s.nextInt();
        }
      }

      int start = N / 2;
      int ans = solve(m, start, start);

      System.out.println(ans);
    }

    s.close();

  }

  static int solve(int[][] m, int x, int y) {
    int sum = 0;
    int currentSteps = 0;
    int stepsTodo = 1;
    int direction = 0;

    while (true) {
      if (x < 0 || x >= m.length || y < 0 || y >= m.length) {
        break;
      }

      if (currentSteps == stepsTodo) {
        currentSteps = 0;
        stepsTodo++;
        direction = (direction + 1) % 4;
      }

      sum += m[y][x];

      x = x + directionsX[direction];
      y = y + directionsY[direction];
      currentSteps++;
    }

    return sum;
  }

}
