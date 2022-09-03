package binarySearchTree2;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457">Problem</a>
 **/
public class FloorInBST {

    private static TreeNode<Integer> floor;

    public static int floorInBST(TreeNode<Integer> root, int X) {
        floor = null;
        recur(root, X);
        return floor.data;
    }

    private static int iterative(TreeNode<Integer> root, int x) {
        TreeNode<Integer> temp = root;
        int ans = 0;
        while (temp != null) {
            if (temp.data == x) return x;
            if (temp.data < x) {
                ans = temp.data;
                temp = temp.right;
            } else temp = temp.left;
        }
        return ans;
    }

    private static void recur(TreeNode<Integer> root, int x) {
        if (root == null) return;
        if (root.data == x) {
            floor = root;
            return;
        }
        if (root.data < x) {
            floor = root;
            recur(root.right, x);
        } else recur(root.left, x);
    }
}
