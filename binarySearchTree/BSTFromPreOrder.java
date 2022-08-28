package binarySearchTree;

import binaryTree1.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/">Problem</a>
 **/
public class BSTFromPreOrder {
    // Naive Solution, will be optimized in future
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int[] inorder = Arrays.copyOf(preorder, n);
        Arrays.sort(inorder);
        var inMap = new HashMap<Integer, Integer>();
        for(int i = 0;i<n;i++) inMap.put(inorder[i], i);
        return form(0, 0, n-1, preorder, n, inMap);
    }

    private TreeNode form(int root, int start, int end, int[] pre, int n, HashMap<Integer, Integer> inMap) {
        if (offBounds(root, n) || start > end || offBounds(start, n) || offBounds(end, n)) return null;
        var node = new TreeNode(pre[root]);
        int inIndex = inMap.get(pre[root]);
        node.left = form(root + 1, start, inIndex - 1, pre, n, inMap);
        node.right = form(root+(inIndex - start)+1, inIndex+1, end, pre, n, inMap);
        return node;
    }

    private boolean offBounds(int i, int n) {
        return i < 0 || i >= n;
    }
}
