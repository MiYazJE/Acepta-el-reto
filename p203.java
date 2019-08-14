import java.util.Scanner;

/**
 * Suma de árboles p298 p203 (Árboles "binarios")
 */

class Tree {

    int val;
    Tree right, left;

    Tree(int x) { val = x; }

    public String toString() {
        return String.valueOf( val );
    }
}

public class p203 {

    final static Scanner s = new Scanner(System.in);

    static void insertNodes(Tree tree) {

        int valor = s.nextInt();
        tree.left = new Tree(valor);
        if (valor != -1) insertNodes(tree.left);

        valor = s.nextInt();
        tree.right = new Tree(valor);
        if (valor != -1) insertNodes(tree.right);
    }

    static Tree mergeTrees(Tree t1, Tree t2) {
        if (t1 == null || t1.val == -1) {
            return t2;
        }
        if (t2 == null || t2.val == -1) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    static boolean space;
    static void printTree(Tree tree) {
        if (tree == null) return;
        if (!space) { System.out.print(tree.val); space = true; }
        else System.out.print(" " + tree.val);
        if (tree.val != -1) printTree(tree.left);
        if (tree.val != -1) printTree(tree.right);
    }

    public static void main(String[] args) {

        while (true) {

            Tree t1 = new Tree( s.nextInt() );
            if (t1.val != -1)
                insertNodes(t1);

            Tree t2 = new Tree( s.nextInt() );
            if (t1.val == -1 && t2.val == -1) break;
            if (t2.val != -1)
                insertNodes(t2);

            Tree merged = mergeTrees(t1, t2);
            space = false;
            printTree( merged );

            System.out.println();
        }

    }

}
