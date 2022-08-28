package binarySearchTree;

import binaryTree1.TreeNode;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/">Problem</a>
 **/
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long min, long max) {
        if (root == null) return true;
        return (root.val > min && root.val < max)
                && isValid(root.left, min, root.val)
                && isValid(root.right, root.val, max);
    }
}
