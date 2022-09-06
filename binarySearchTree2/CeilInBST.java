package binarySearchTree2;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/ceil-from-bst_920464">Problem</a>
 **/
public class CeilInBST {
    private static TreeNode<Integer> ceil;

    public static int findCeil(TreeNode<Integer> root, int X) {
        ceil = new TreeNode<>(-1);
        recur(root, X);
        return ceil.data;
    }

    private static int iterative(TreeNode<Integer> root, int x) {
        TreeNode<Integer> temp = root;
        int ans = -1;
        while (temp != null) {
            if (temp.data == x) return x;
            if (temp.data > x) {
                ans = temp.data;
                temp = temp.left;
            } else temp = temp.right;
        }
        return ans;
    }

    private static void recur(TreeNode<Integer> root, int x) {
        if (root == null) return;
        if (root.data == x) {
            ceil = root;
            return;
        }
        if (root.data > x) {
            ceil = root;
            recur(root.left, x);
        } else recur(root.right, x);
    }
}
