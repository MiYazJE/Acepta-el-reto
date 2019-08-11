import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

class TreeNode {
    ArrayList<TreeNode> nodes;
    TreeNode() { nodes = new ArrayList<>(); }
}

public class p310 {

    static int index;
    static int altura;

    static void insertNodes(TreeNode tree, String[] input) {
        if (index == input.length) return;
        int childs = Integer.parseInt(input[index++]);
        for (int i = 0; i < childs; i++)
            tree.nodes.add(new TreeNode());
        for (TreeNode n : tree.nodes)
            insertNodes(n, input);
    }

    static void getAltura(TreeNode tree, int temp) {
        if (tree.nodes.isEmpty()) {
            if (temp > altura) altura = temp;
            return;
        }
        for (TreeNode n : tree.nodes)
            getAltura(n, temp + 1);
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos = s.nextInt(); s.nextLine();
        String[] input;

        for (int i = 0; i < casos; i++) {

            input = s.nextLine().split(" ");

            TreeNode tree = new TreeNode();
            index = 0;
            insertNodes(tree, input);

            altura = Integer.MIN_VALUE;
            getAltura(tree, 1);

            System.out.println( altura );
        }

    }

}
