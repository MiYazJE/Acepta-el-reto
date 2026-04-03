import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p793 {

  static class Direction {
    int steps;
    String dir;

    Direction(int steps, String direction) {
      this.steps = steps;
      this.dir = direction;
    }
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (true) {
      int N = s.nextInt();
      if (N == 0)
        break;

      int minX = 0;
      int maxX = 0;
      int minY = 0;
      int maxY = 0;

      int currentX = 0, currentY = 0;
      ArrayList<Direction> directions = new ArrayList<>();

      for (int i = 0; i < N; i++) {
        int steps = Integer.parseInt(s.next());
        String direction = s.next(); // N, S, E, O
        directions.add(new Direction(steps, direction));

        if (direction.equals("N")) { // up
          currentY -= steps;
        }
        if (direction.equals("S")) { // down
          currentY += steps;
        }
        if (direction.equals("O")) { // left
          currentX -= steps;
        }
        if (direction.equals("E")) { // right
          currentX += steps;
        }

        minX = Math.min(minX, currentX);
        maxX = Math.max(maxX, currentX);

        minY = Math.min(minY, currentY);
        maxY = Math.max(maxY, currentY);
      }

      int xLength = maxX - minX + 1;
      int YLength = maxY - minY + 1;
      char[][] m = new char[YLength + 2][xLength + 2];
      for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < m[0].length; j++) {
          if (i == 0 || i == m.length - 1 || j == 0 || j == m[0].length - 1) {
            m[i][j] = '#'; 
          } else {
            m[i][j] = ' '; 
          }
        }
      }

      int startX = -minX + 1;
      int startY = -minY + 1;

      currentX = startX;
      currentY = startY;
      int directionsLength = directions.size();
      for (int i = 0; i < directionsLength; i++) {
        Direction direction = directions.get(i);
        if (direction.dir.equals("N")) { // up
          for (int j = 0; j < direction.steps; j++) {
            currentY--;
            m[currentY][currentX] = '.';
          }
        }
        if (direction.dir.equals("S")) { // down
          for (int j = 0; j < direction.steps; j++) {
            currentY++;
            m[currentY][currentX] = '.';
          }
        }
        if (direction.dir.equals("O")) { // left
          for (int j = 0; j < direction.steps; j++) {
            currentX--;
            m[currentY][currentX] = '.';
          }
        }
        if (direction.dir.equals("E")) { // right
          for (int j = 0; j < direction.steps; j++) {
            currentX++;
            m[currentY][currentX] = '.';
          }
        }

        if (i == directionsLength - 1) {
          m[currentY][currentX] = 'F';
        }
      }

      m[startY][startX] = 'O';

      for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < m[i].length; j++) {
          System.out.print(m[i][j]);
        }
        System.out.println();
      }

      System.out.println();
    }

    s.close();

  }

}
