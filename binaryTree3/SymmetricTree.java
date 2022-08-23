package binaryTree3;

import binaryTree1.TreeNode;

/**
* <a href="https://leetcode.com/problems/symmetric-tree/">Problem</a>
**/
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
}
