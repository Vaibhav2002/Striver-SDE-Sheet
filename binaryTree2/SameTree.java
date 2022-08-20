package binaryTree2;

import binaryTree1.TreeNode;

/**
* <a href="https://leetcode.com/problems/same-tree/">Problem</a>
**/
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q);
    }

    private boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
