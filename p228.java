import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Arbol {
    char val;
    Arbol left, right;
    Arbol(char x) { val = x; }
    public String toString() { return ""+val; }
}

public class p228 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int index;

    static void insertNodes(Arbol node, String input) {
        if (index == input.length()) return;
        char temp = input.charAt(index++);
        if (temp != ' ') {
            node.left = new Arbol(temp);
            insertNodes(node.left, input);
        }
        if (index == input.length()) return;
        temp = input.charAt(index++);
        if (temp != ' ') {
            node.right = new Arbol(temp);
            insertNodes(node.right, input);
        }
    }

    static void invertTree(Arbol node) {
        if (node == null) return;
        swap( node );
        invertTree(node.left);
        invertTree(node.right);
    }

    static void swap(Arbol tree) {
        Arbol temp = tree.left;
        tree.left  = tree.right;
        tree.right = temp;
    }

    static void printTree(Arbol node) {
        if (node == null) return;
        System.out.print(node.val);
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) throws IOException {

        String line;

        while (true) {

            line = reader.readLine();
            if (line == null) return;

            Arbol tree = new Arbol(line.charAt(0));
            index = 1; insertNodes(tree, line);
            invertTree(tree);
            printTree(tree);
            System.out.println();

        }

    }

}
