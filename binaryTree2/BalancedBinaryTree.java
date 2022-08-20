package binaryTree2;

import binaryTree1.TreeNode;

/**
 * <a href="https://leetcode.com/problems/balanced-binary-tree/">Problem</a>
 **/
public class BalancedBinaryTree {

    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        if(!isBalanced) return 0;
        isBalanced = Math.abs(left - right) <= 1;
        return 1+Math.max(left, right);
    }
}
