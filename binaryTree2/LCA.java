package binaryTree2;

import binaryTree1.TreeNode;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">Problem</a>
 **/
public class LCA {

    private boolean[] found;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        found = new boolean[2];
        TreeNode lca = dfs(root, p, q);
        if(found[0] && found[1]) return lca;
        else return null;
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode temp = (root == p || root == q) ? root : null;
        if (root == p) found[0] = true;
        if (root == q) found[1] = true;
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (temp != null) return temp;
        if (left != null && right != null) return root;
        else return (left != null) ? left : right;
    }


}
