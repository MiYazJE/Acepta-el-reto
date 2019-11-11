import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p218 {

    static String[] inOrden;
    static String[] postOrden;
    static boolean space;

    static void print(boolean[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print((m[i][j]) ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    static void printPreOrden(boolean[][] tree, int left, int right, int depht, int max) {
        boolean exit = false;
        for (int i = depht; i < max && !exit; i++) {
            for (int j = left; j < right && !exit; j++) {
                if (tree[i][j]) {
                    if (space) System.out.print(" ");
                    System.out.print(inOrden[j]);
                    space = true;
                    printPreOrden(tree, left, j, i + 1, max);
                    printPreOrden(tree, j + 1, right, i + 1, max);
                    exit = true;
                }
            }
        }
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int nodos;
        boolean[][] tree;

        while (true) {

            nodos = s.nextInt();
            if (nodos == 0) break;
            s.nextLine();

            tree = new boolean[nodos][nodos];
            inOrden   = s.nextLine().split(" ");
            postOrden = s.nextLine().split(" ");

            for (int i = nodos - 1; i >= 0; i--) {
                boolean exit = false;
                for (int j = 0; j < nodos && !exit; j++) {
                    if (postOrden[i].equals(inOrden[j])) {
                        tree[nodos - (i + 1)][j] = true;
                        exit = true;
                    }
                }
            }

            // print(tree);
            space = false;
            printPreOrden(tree, 0, nodos, 0, nodos);
            System.out.println();
        }

    }

}
