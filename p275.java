import java.util.Scanner;

class N {
    char val;
    N right, left;
    N(char x) {
        val = x;
    }
}

public class p275 {

    static void leerArbol(N node) {
        if (index == input.length()) return;

        if (input.charAt(index) == 'R') {
            node.left = new N(input.charAt(index));
            index++;
            leerArbol(node.left);
        }

        index++;
        if (input.charAt(index) == 'R') {
            node.right = new N(input.charAt(index));
            index++;
            leerArbol(node.right);
        }
    }

    static int getDeep(N node, int altura) {
        if (node == null) return altura;
        return Math.max(getDeep(node.left, altura + 1), getDeep(node.right, altura + 1));
    }

    static boolean estaEquilibrado(N node) {
        if (node == null) return true;

        int left = getDeep(node.left, 0);
        int right = getDeep(node.right, 0);

        boolean correct = estaEquilibrado(node.left) && estaEquilibrado(node.right);
        if (Math.abs(left - right) > 1) return false;

        return correct;
    }

    static int index;
    static String input;

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        for (int i = s.nextInt(); i > 0; i--) {

            input = s.next();

            index = 0;
            N tree = new N(input.charAt(index++));
            leerArbol(tree);

            System.out.println( (estaEquilibrado(tree)) ? "SI" : "NO" );
        }

    }

}
