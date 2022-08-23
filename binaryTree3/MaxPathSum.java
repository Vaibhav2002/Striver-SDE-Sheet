package binaryTree3;

import binaryTree1.TreeNode;

/**
* <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">Problem</a>
**/
public class MaxPathSum {

    private int maxPath;

    public int maxPathSum(TreeNode root) {
        maxPath = 0;
        find(root);
        return maxPath;
    }

    private int find(TreeNode root){
        if(root == null) return 0;
        int left = find(root.left), right = find(root.right);
        int max = root.val;
        max = Math.max(max, root.val+Math.max(left, right));
        maxPath = Math.max(maxPath, root.val+left+right);
        maxPath = Math.max(maxPath, max);
        return max;
    }
}
