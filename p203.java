import java.util.Scanner;

class Tree {

    int val;
    Tree right, left;

    Tree(int val) { this.val = val; }

    public String toString() {
        return "val -> '"+ val + "', left -> " + left + ", right -> " + right;
    }
}

public class p203 {

    // 1 2 -1 -1 3 -1 -1
    /*
          1
      2       3
  -1   -1   -1  -1
     */

    static Scanner s = new Scanner(System.in);

    static void insertNodes(Tree tree) {

        // Primero inserto por la izquierda recursivamente, si encuentro un -1 inserto y corto recursión.
        int num = s.nextInt();
        tree.left = new Tree(num);
        if (num != -1) insertNodes(tree.left);

        // Despues inserto por la derecha, si se encuentra un -1 lo inserto y corto recursión.
        num = s.nextInt();
        tree.right = new Tree(num);
        if (num != -1) insertNodes(tree.right);
    }

    /**
     * Forma un arbol(t3) en función de la suma de los nodos del árbol t1 y el árbol t2.
     * @param t1
     * @param t2
     * @param t3
     */
    static void sumTrees(Tree t1, Tree t2, Tree t3) {

        Tree next1, next2;

        // Reemplazo valores nulos por -1
        int n1 = (t1 != null && t1.left != null) ? t1.left.val : -1;
        int n2 = (t2 != null && t2.left != null) ? t2.left.val : -1;

        // Si los valores de los dos arboles son -1 significa ya no hay mas nodos hijos
        // Insertaremos -1
        if (n1 == -1 && n2 == -1) {
            t3.left = new Tree(-1);
        }
        else {
            // Si no hay que sumar
            if (n1 == -1) n1 = 0;
            if (n2 == -1) n2 = 0;
            t3.left = new Tree(n1 + n2);
            next1 = (t1 != null && t1.left != null) ? t1.left : t1;
            next2 = (t2 != null && t2.left != null) ? t2.left : t2;
            sumTrees(next1, next2, t3.left);
        }

        // Lo mismo pero por los nodos de la derecha
        n1 = (t1 != null && t1.right != null) ? t1.right.val : -1;
        n2 = (t2 != null && t2.right != null) ? t2.right.val : -1;

        if (n1 == -1 && n2 == -1) {
            t3.right = new Tree(-1);
        }
        else {
            if (n1 == -1) n1 = 0;
            if (n2 == -1) n2 = 0;
            t3.right = new Tree(n1 + n2);
            next1 = (t1 != null && t1.right != null) ? t1.right : t1;
            next2 = (t2 != null && t2.right != null) ? t2.right : t2;
            sumTrees(next1, next2, t3.right);
        }

    }

    static void printTree(Tree tree) {
        if (tree.left != null) {
            System.out.print(" " + tree.left.val);
            printTree(tree.left);
        }

        if (tree.right != null) {
            System.out.print(" " + tree.right.val);
            printTree(tree.right);
        }
    }

    public static void main(String[] args) {

        int raiz1, raiz2;

        while (true) {

            raiz1 = s.nextInt();
            Tree t1 = new Tree(raiz1);
            if (raiz1 != -1) {
                insertNodes(t1);
            }

            raiz2 = s.nextInt();
            if (raiz1 == -1 && raiz2 == -1) break;
            Tree t2 = new Tree(raiz2);
            if (raiz2 != -1) {
                insertNodes(t2);
            }

            // Evito sumar un negativo, remplazo el valor negativo por un 0
            int n1 = (t1.val == -1) ? 0 : t1.val;
            int n2 = (t2.val == -1) ? 0 : t2.val;

            // Asigno la raiz al nuevo arbol con la suma de las raizes
            Tree t3 = new Tree(n1 + n2);
            sumTrees(t1, t2, t3);

            // Imprimo la raiz primero, asi evito el presentation error.
            System.out.print(t3.val);
            printTree( t3 );
            System.out.println();

        }

    }

}
