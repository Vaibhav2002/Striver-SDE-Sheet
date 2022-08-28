package binarySearchTree;

import binaryTree1.TreeNode;

/**
* <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">Problem</a>
**/
public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return form(nums, 0, nums.length - 1);
    }

    private TreeNode form(int[] nums, int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        var node = new TreeNode(nums[mid]);
        node.left = form(nums, start, mid - 1);
        node.right = form(nums, mid+1, end);
        return node;
    }
}
