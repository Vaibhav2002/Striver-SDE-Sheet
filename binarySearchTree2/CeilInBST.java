package binarySearchTree2;

public class CeilInBST {
    private static TreeNode<Integer> ceil;

    public static int findCeil(TreeNode<Integer> root, int X) {
        ceil = null;
        recur(root, X);
        return ceil.data;
    }

    private static int iterative(TreeNode<Integer> root, int x) {
        TreeNode<Integer> temp = root;
        int ans = 0;
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
