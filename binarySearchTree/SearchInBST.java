package binarySearchTree;

import binaryTree1.TreeNode;

/**
* <a href="https://leetcode.com/problems/search-in-a-binary-search-tree/">Problem</a>
**/
public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}
