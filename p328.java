import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p328 {

    private static final int FUERA = -1;

    private static HashMap<Character, Character> nextDirection = new HashMap<>();

    static void print(int[][] m) {
        for (int i = 1; i < m.length - 1; i++) {
            for (int j = 1; j < m[i].length - 1; j++) {
                System.out.print(m[i][j]);
                if (j < m[i].length - 2) System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("---");
    }

    static int[][] init(int f, int c) {

        int[][] m = new int[f + 2][c + 2];

        for (int i = 0; i < c + 1; i++)
            m[0][i] = m[f + 1][i] = FUERA;
        for (int i = 0; i < f + 1; i++)
            m[i][0] = m[i][c + 1] = FUERA;

        return m;
    }

    static void movePollito(int f, int c, char direction, int moves, int total, int steps, boolean flag, int[][] grid) {

        if (grid[f][c] == FUERA || steps == 0)
            return;

        grid[f][c]++;

        char newDirection = direction;

        if (moves == 0) {
            newDirection = nextDirection.get(direction);
            if (flag) {
                total++;
                moves = total;
            }
            else moves = total;
            flag = !flag;
        }

        if (direction == 'N') f--;
        else if (direction == 'S') f++;
        else if (direction == 'E') c++;
        else c--;

        direction = newDirection;

        movePollito(f, c, direction, moves - 1, total, steps - 1, flag, grid);
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        nextDirection.put('N', 'E');
        nextDirection.put('E', 'S');
        nextDirection.put('S', 'W');
        nextDirection.put('W', 'N');

        int c, f, steps, x, y;
        int[][] m;
        char direction;
        int casos = s.nextInt();

        while (casos-- != 0) {

            f = s.nextInt();
            c = s.nextInt();

            m = init(f, c);

            for (int i = s.nextInt(); i > 0; i--) {

                y = s.nextInt();
                x = s.nextInt();
                direction = s.next().charAt(0);
                steps = s.nextInt();

                m[y][x]++;
                if (direction == 'N') y--;
                else if (direction == 'S') y++;
                else if (direction == 'E') x++;
                else x--;

                movePollito(y, x, nextDirection.get(direction), 0, 1, steps, true, m);
            }

            print( m );

        }

    }

}
