package binarySearchTree;

import binaryTree1.TreeNode;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">Problem</a>
 **/
public class LCAInBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    private TreeNode find(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        if (root.val < p && root.val < q) return find(root.right, p, q);
        else if (root.val > p && root.val > q) return find(root.left, p, q);
        else return root;
    }
}
