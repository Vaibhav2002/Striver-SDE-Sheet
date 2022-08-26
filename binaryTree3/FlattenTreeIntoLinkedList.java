package binaryTree3;

import binaryTree1.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Problem</a>
**/
public class FlattenTreeIntoLinkedList {

    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        recur(root);
    }

    private void recur(TreeNode root){
        if(root == null) return;
        recur(root.right);
        recur(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }

    private void iterative(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode cur = st.peek();
            if(cur.right!=null) st.push(cur.right);
            if(cur.left!=null) st.push(cur.left);
            cur.right = st.peek();
            cur.left = null;
        }
    }

    private void morris(TreeNode root){
        if(root == null) return;
        TreeNode cur = root;
        while(cur !=null){
            if(cur.left !=null){
                TreeNode inLast = cur.left;
                while(inLast.right!=null) inLast = inLast.right;
                inLast.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
