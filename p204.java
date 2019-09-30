import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Rubén Saiz
 */

class Node {
    char val;
    Node left, right;
    Node(char x) { val = x; }
    public String toString() { return "" + val; }
}

public class p204 {

    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int index;

    static void readTree(Node node, String input) {
        if (index == input.length()) return;
        char temp = input.charAt(index++);
        node.left = new Node(temp);
        if (temp != '.' && temp != '*') {
            readTree(node.left, input);
        }
        if (index == input.length()) return;
        temp = input.charAt(index++);
        node.right = new Node(temp);
        if (temp != '.' && temp != '*') {
            readTree(node.right, input);
        }
    }

    static boolean correcto;

    static int esArbolDeNAvidad(Node node, int bolasIzq, int bolasDer, char direction) {
        if (node == null || node.val == '.')
            return (direction == 'l') ? bolasIzq : bolasDer;

        int sum;
        sum = (node.val == 'Y' && node.left.val == '*') ? 1 : 0;
        int left = esArbolDeNAvidad(node.left, bolasIzq + sum, bolasDer, 'l');

        sum = (node.val == 'Y' && node.right.val == '*') ? 1 : 0;

        int right = esArbolDeNAvidad(node.right, bolasIzq, bolasDer + sum, 'r');
        if (Math.abs(left - right) > 1) correcto = false;

        return left + right;
    }

    public static void main(String[] args) throws IOException {

        String input;

        while (true) {

            input = reader.readLine();
            if (input == null) return;

            Node tree = new Node(input.charAt(0));
            index = 1;
            readTree(tree, input);

            correcto = true;
            esArbolDeNAvidad(tree, 0, 0, 'l');

            System.out.println( (correcto) ? "OK" : "KO" );
        }

    }

}
