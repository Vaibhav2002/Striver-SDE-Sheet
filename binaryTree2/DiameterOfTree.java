package binaryTree2;

import binaryTree1.TreeNode;

/**
* <a href="https://leetcode.com/problems/diameter-of-binary-tree/">Problem</a>
**/
public class DiameterOfTree {
    private int dia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return dia;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        int height = 1 + Math.max(left, right);
        dia = Math.max(dia, height);
        return height;
    }
}
