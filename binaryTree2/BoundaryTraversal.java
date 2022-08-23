package binaryTree2;

import binaryTree1.TreeNode;

import java.util.ArrayList;

public class BoundaryTraversal {

    public static ArrayList<Integer> traverseBoundary(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (!isLeaf(root)) ans.add(root.val);
        addLeftBoundary(root.left, ans);
        addLeafNodes(root, ans);
        ArrayList<Integer> right = new ArrayList<>();
        addRightBoundary(root.right, right);
        ans.addAll(right);
        return ans;
    }

    private static void addLeftBoundary(TreeNode root, ArrayList<Integer> ans) {
        if (root == null || isLeaf(root)) return;
        ans.add(root.val);
        if (root.left != null) addLeftBoundary(root.left, ans);
        else addLeftBoundary(root.right, ans);
    }

    private static void addLeafNodes(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) return;
        addLeafNodes(root.left, ans);
        if (isLeaf(root)) ans.add(root.val);
        addLeafNodes(root.right, ans);
    }

    private static void addRightBoundary(TreeNode root, ArrayList<Integer> right) {
        if (root == null || isLeaf(root)) return;
        right.add(0, root.val);
        if (root.right != null) addRightBoundary(root.right, right);
        else addRightBoundary(root.left, right);
    }

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
