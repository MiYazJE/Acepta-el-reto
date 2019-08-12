import java.util.Scanner;

/**
 * Suma de árboles AER p203 (Árboles "binarios")
 */

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
        int valor = s.nextInt();
        tree.left = new Tree(valor);
        if (valor != -1) insertNodes(tree.left);

        // Despues inserto por la derecha, si se encuentra un -1 lo inserto y corto recursión.
        valor = s.nextInt();
        tree.right = new Tree(valor);
        if (valor != -1) insertNodes(tree.right);
    }

    /**
     * Forma un arbol(t3) con la suma de los valores de los nodos del árbol t1 y el árbol t2.
     * Si un nodo es -1 suma 0, si los dos nodos son -1 significa que no tienen hijos.
     * @param t1 : árbol sumar
     * @param t2 : árbol sumar
     * @param t3 : árbol generado
     */
    static void sumTrees(Tree t1, Tree t2, Tree t3) {

        Tree t1_next, t2_next;

        // Reemplazo valores nulos por -1
        int valor_t1 = (t1 != null && t1.left != null) ? t1.left.val : -1;
        int valor_t2 = (t2 != null && t2.left != null) ? t2.left.val : -1;

        // Si los valores de los dos arboles son -1 significa ya no hay mas nodos hijos
        // Insertaremos -1
        if (valor_t1 == -1 && valor_t2 == -1) {
            t3.left = new Tree(-1);
        }
        else {
            // Si no hay que sumar, reemplazamos los valores negativos por 0
            if (valor_t1 == -1) valor_t1 = 0;
            if (valor_t2 == -1) valor_t2 = 0;

            t3.left = new Tree(valor_t1 + valor_t2);

            // Prevenimos pasar nodos nulos.
            t1_next = (t1 != null && t1.left != null) ? t1.left : t1;
            t2_next = (t2 != null && t2.left != null) ? t2.left : t2;

            // Hacemos lo mismo con los siguientes nodos
            sumTrees(t1_next, t2_next, t3.left);
        }

        // Lo mismo pero por los nodos de la derecha
        valor_t1 = (t1 != null && t1.right != null) ? t1.right.val : -1;
        valor_t2 = (t2 != null && t2.right != null) ? t2.right.val : -1;

        if (valor_t1 == -1 && valor_t2 == -1) {
            t3.right = new Tree(-1);
        }
        else {
            if (valor_t1 == -1) valor_t1 = 0;
            if (valor_t2 == -1) valor_t2 = 0;

            t3.right = new Tree(valor_t1 + valor_t2);

            t1_next = (t1 != null && t1.right != null) ? t1.right : t1;
            t2_next = (t2 != null && t2.right != null) ? t2.right : t2;

            sumTrees(t1_next, t2_next, t3.right);
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
            // Si la raíz de un árbol es -1 no insertamos nodos
            if (raiz1 != -1) {
                insertNodes(t1);
            }

            raiz2 = s.nextInt();
            // Si las dos raíces son -1 terminamos
            if (raiz1 == -1 && raiz2 == -1) break;
            Tree t2 = new Tree(raiz2);
            if (raiz2 != -1) {
                insertNodes(t2);
            }

            // Evito sumar un negativo, remplazo el valor negativo por un    0
            int n1 = (t1.val == -1) ? 0 : t1.val;
            int n2 = (t2.val == -1) ? 0 : t2.val;

            // Asigno la raíz al nuevo arbol con la suma de las raíces
            Tree t3 = new Tree(n1 + n2);
            sumTrees(t1, t2, t3);

            // Imprimo la raíz primero, asi evito el presentation error(PE). System.out.println(" " + valor);
            System.out.print(t3.val);
            printTree( t3 );

            System.out.println();
        }

    }

}
