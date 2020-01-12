import java.util.*;

/**
 * @author Rubén Saiz
 */

public class p288 {

    static int[] uf, sizes;

    static int union(int i, int j) {
        if (isConnected(i, j)) return 0;
        int root_i = root(i), root_j = root(j);
        uf[root_i] = root_j;
        sizes[root_j] += sizes[root_i];
        return sizes[root_j];
    }

    static int root(int i) {
        while (i != uf[i]) i = uf[i];
        return uf[i];
    }

    static boolean isConnected(int i, int j) {
        return root(i) == root(j);
    }
    

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int column, row, max, n;
        String input;
        StringBuilder str = new StringBuilder();
        int[][] grid = new int[1001][1001];

        while (s.hasNext()) {

            row = s.nextInt();
            column = s.nextInt(); s.nextLine();

            for (int i = 1; i <= row; i++)
                for (int j = 1; j <= column; j++)
                    grid[i][j] = 0;

            uf     = new int[(row + 1) * (column + 1) + 4];
            sizes = new int[(row + 1) * (column + 1) + 4];

            for (int i = 1; i <= row; i++) {
                input = s.nextLine();
                for (int j = 0; j < input.length(); j++) {
                    if (input.charAt(j) == '#') {
                        grid[i][j + 1] = 1;
                    }
                }
            }

            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= column; j++) {
                    if (grid[i][j] == 1) {
                        int index = i * column + j;
                        uf[index] = index;
                        sizes[index] = 1;
                    }
                }
            }

            max = 0; //CAMBIO
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= column; j++) {
                    if (grid[i][j] == 1) {
                        max = Math.max(max, 1);
                        if (i > 1) {
                            if (grid[i - 1][j] == 1) {
                                max = Math.max(max, union(i * column + j, (i - 1) * column + j));
                            }
                        }
                        if (i < row) {
                            if (grid[i + 1][j] == 1) {
                                max = Math.max(max, union(i * column + j, (i + 1) * column + j));
                            }
                        }
                        if (j > 1) {
                            if (grid[i][j - 1] == 1) {
                                max = Math.max(max, union(i * column + j, i * column + (j - 1)));
                            }
                        }
                        if (j < column) {
                            if (grid[i][j + 1] == 1) {
                                max = Math.max(max, union(i * column + j, i * column + (j + 1)));
                            }
                        }
                        if (i < row && j < column) {
                            if (grid[i + 1][j + 1] == 1) {
                                max = Math.max(max, union(i * column + j, (i + 1) * column + (j + 1)));
                            }
                        }
                        if (i > 1 && j > 1) {
                            if (grid[i - 1][j - 1] == 1) {
                                max = Math.max(max, union(i * column + j, (i - 1) * column + (j - 1)));
                            }
                        }
                        if (i < row && j > 1) {
                            if (grid[i + 1][j - 1] == 1) {
                                max = Math.max(max, union(i * column + j, (i + 1) * column + (j - 1)));
                            }
                        }
                        if (i > 1 && j < column) {
                            if (grid[i - 1][j + 1] == 1) {
                                max = Math.max(max, union(i * column + j, (i - 1) * column + (j + 1)));
                            }
                        }
                    }
                }
            }

            str.append( max );

            n = s.nextInt();
            for (int k = 0; k < n; k++) {

                int i = s.nextInt();
                int j = s.nextInt();

                int index = i * column + j;
                uf[index] = index;
                sizes[index] = 1;
                grid[i][j] = 1;

                max = Math.max(max, 1);
                if (i > 1) {
                    if (grid[i - 1][j] == 1) {
                        max = Math.max(max, union(i * column + j, (i - 1) * column + j));
                    }
                }
                if (i < row) {
                    if (grid[i + 1][j] == 1) {
                        max = Math.max(max, union(i * column + j, (i + 1) * column + j));
                    }
                }
                if (j > 1) {
                    if (grid[i][j - 1] == 1) {
                        max = Math.max(max, union(i * column + j, i * column + (j - 1)));
                    }
                }
                if (j < column) {
                    if (grid[i][j + 1] == 1) {
                        max = Math.max(max, union(i * column + j, i * column + (j + 1)));
                    }
                }
                if (i < row && j < column) {
                    if (grid[i + 1][j + 1] == 1) {
                        max = Math.max(max, union(i * column + j, (i + 1) * column + (j + 1)));
                    }
                }
                if (i > 1 && j > 1) {
                    if (grid[i - 1][j - 1] == 1) {
                        max = Math.max(max, union(i * column + j, (i - 1) * column + (j - 1)));
                    }
                }
                if (i < row && j > 1) {
                    if (grid[i + 1][j - 1] == 1) {
                        max = Math.max(max, union(i * column + j, (i + 1) * column + (j - 1)));
                    }
                }
                if (i > 1 && j < column) {
                    if (grid[i - 1][j + 1] == 1) {
                        max = Math.max(max, union(i * column + j, (i - 1) * column + (j + 1)));
                    }
                }

                str.append(" ").append( max );
            }

            System.out.println( str.toString() );
            str.delete(0, str.length());
        }

    }

}
