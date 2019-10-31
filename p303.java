import java.util.Scanner;

class ArbolNode {
    ArbolNode left, right;
    int val;
    ArbolNode(int x) {
        val = x;
    }
}

public class p303 {

    final static Scanner s = new Scanner(System.in);

    static boolean isBst(ArbolNode node, Integer min, Integer max) {
        if (node == null) return true;
        if (min != null && node.val <= min ||
            max != null && node.val >= max)
            return false;
        return isBst(node.left, min, node.val) &&
                isBst(node.right, node.val, max);
    }

    static int getDepht(ArbolNode node, int depth) {
        if (node == null) return depth;
        return Math.max(getDepht(node.left, depth + 1), getDepht(node.right, depth + 1));
    }

    static boolean valid(ArbolNode node) {
        if (node == null) return true;
        int left = getDepht(node.left, 0);
        int right = getDepht(node.right, 0);
        if (Math.abs(left - right) > 1) return false;
        return valid(node.left) && valid(node.right);
    }

    static void readTree(ArbolNode node) {
        int value = s.nextInt();
        if (value != -1) {
            node.left = new ArbolNode(value);
            readTree(node.left);
        }
        value = s.nextInt();
        if (value != -1) {
            node.right = new ArbolNode(value);
            readTree(node.right);
        }
    }

    public static void main(String[] args) {

        boolean valid;
        int casos = s.nextInt();

        while (casos-- != 0) {

            ArbolNode tree = new ArbolNode(s.nextInt());

            if (tree.val == -1) System.out.println("SI");
            else {
                readTree(tree);
                valid = isBst( tree, null, null ) && valid(tree);

                System.out.println( (valid) ? "SI" : "NO");
            }
        }

    }

}
