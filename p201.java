package TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TreeNode {
    char val;
    TreeNode left, right;
    TreeNode(char x) { val = x; }
    public String toString() {
        return val + "";
    }
}

public class p201 {

    static void detectTwoSons(TreeNode node) {
        if (node == null || !two) return;
        if ((node.left != null && node.right == null) || (node.left == null && node.right != null))
            two = false;
        detectTwoSons(node.left);
        detectTwoSons(node.right);
    }

    static void detectOneSon(TreeNode node) {
        if (node == null || !one) return;
        if (node.left != null && node.right != null) { one = false; return; }
        detectOneSon(node.left);
        detectOneSon(node.right);
    }

    static void read(TreeNode node) {
        if (input.charAt(pos) != '.') {
            node.left = new TreeNode(input.charAt(pos++));
            read(node.left);
        }
        pos++;
        if (input.charAt(pos) != '.') {
            node.right = new TreeNode(input.charAt(pos++));
            read(node.right);
        }
    }

    static int pos;
    static String input;
    static boolean one, two;
    final static BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        while (true) {

            input = s.readLine();

            pos = 0;
            TreeNode node = new TreeNode(input.charAt(pos++));
            if (node.val == '.') break;

            read(node);
            one = two = true;
            detectOneSon(node);
            detectTwoSons(node);
            if (one) System.out.print("1");
            if (two) System.out.print("2");
            if (!one && !two) System.out.print("N");

            System.out.println();
        }

    }

}
