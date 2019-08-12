import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode right, left;
    TreeNode(int val) { this.val = val; }

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

    static void insertNodes(TreeNode tree) {

        int num = s.nextInt();
        tree.left = new TreeNode(num);
        if (num != -1) insertNodes(tree.left);

        num = s.nextInt();
        tree.right = new TreeNode(num);
        if (num != -1) insertNodes(tree.right);
    }

    static void sumTrees(TreeNode t1, TreeNode t2, TreeNode t3) {

        int n1 = (t1 != null && t1.left != null) ? t1.left.val : -1;
        int n2 = (t2 != null && t2.left != null) ? t2.left.val : -1;

        if (n1 == -1 && n2 == -1) {
            t3.left = new TreeNode(-1);
        }
        else {
            if (n1 == -1) n1 = 0;
            if (n2 == -1) n2 = 0;
            t3.left = new TreeNode(n1 + n2);
            sumTrees(t1.left, t2.left, t3.left);
        }

        n1 = (t1 != null && t1.right != null) ? t1.right.val : -1;
        n2 = (t2 != null && t2.right != null) ? t2.right.val : -1;

        if (n1 == -1 && n2 == -1) {
            t3.right = new TreeNode(-1);
        }
        else {
            if (n1 == -1) n1 = 0;
            if (n2 == -1) n2 = 0;
            t3.right = new TreeNode(n1 + n2);
            sumTrees(t1.right, t2.right, t3.right);
        }

    }

    public static void main(String[] args) {

        while (true) {

            TreeNode t1 = new TreeNode(s.nextInt());
            insertNodes(t1);

            TreeNode t2 = new TreeNode(s.nextInt());
            insertNodes(t2);

            TreeNode t3 = new TreeNode(t1.val + t2.val);
            sumTrees(t1, t2, t3);

            System.out.println();

        }

    }

}
