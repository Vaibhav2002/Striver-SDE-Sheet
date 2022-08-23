package binaryTree3;

import binaryTree1.TreeNode;

import java.util.HashMap;

/**
* <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Problem</a>
**/
public class TreeFromPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var map = inOrderMap(inorder);
        return form(0, 0, preorder.length, preorder, map);
    }

    private TreeNode form(int root, int l, int h, int[] pre, HashMap<Integer, Integer> map){
        if(l>=pre.length ||  h<0 || root>=pre.length || l>h) return null;
        var curNode = new TreeNode(pre[root]);
        int rootPos = map.get(pre[root]);
        curNode.left = form(root+1, l, rootPos - 1, pre, map);
        curNode.right = form(root+rootPos+l+1, rootPos+1, h, pre, map);
        return curNode;
    }

    private HashMap<Integer, Integer> inOrderMap(int[] in){
        var map = new HashMap<Integer, Integer>();
        for(int i = 0;i<in.length;i++) map.put(in[i], i);
        return map;
    }
}
