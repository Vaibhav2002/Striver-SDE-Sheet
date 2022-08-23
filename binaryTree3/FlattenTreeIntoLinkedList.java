package binaryTree3;

import binaryTree1.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
* <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Problem</a>
**/
public class FlattenTreeIntoLinkedList {
    public void flatten(TreeNode root) {
        List<TreeNode> pre = new ArrayList<>();
        getPreOrder(root, pre);
        for(int i = 1;i<pre.size();i++){
            root.right = pre.get(i);
            root.left = null;
            root = root.right;
        }
    }

    private void getPreOrder(TreeNode root, List<TreeNode> pre){
        if(root == null) return;
        pre.add(root);
        getPreOrder(root.left, pre);
        getPreOrder(root.right, pre);
    }
}
