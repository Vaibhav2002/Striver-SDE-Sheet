package binaryTree3;

import binaryTree1.TreeNode;

import java.util.HashMap;

/**
* <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">Problem</a>
**/
public class TreeFromPostAndIn {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        var map = inOrderMap(inorder);
        return form(postorder.length - 1, 0, postorder.length, postorder, map);
    }

    private TreeNode form(int root, int l, int h, int[] pre, HashMap<Integer, Integer> map){
        if(l>=pre.length ||  h<0 || root<0 || l>h) return null;
        var curNode = new TreeNode(pre[root]);
        int rootPos = map.get(pre[root]);
        curNode.right = form(root - 1, rootPos+1, h, pre, map);
        curNode.left = form(root - rootPos - l - 1, l, rootPos - 1, pre, map);
        return curNode;
    }

    private HashMap<Integer, Integer> inOrderMap(int[] in){
        var map = new HashMap<Integer, Integer>();
        for(int i = 0;i<in.length;i++) map.put(in[i], i);
        return map;
    }
}
