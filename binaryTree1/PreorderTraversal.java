package binaryTree1;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">Problem</a>
**/
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        bfs(root, pre);
        return pre;
    }

    private void dfs(TreeNode root, List<Integer> pre){
        if(root == null)return;
        pre.add(root.val);
        dfs(root.left, pre);
        dfs(root.right, pre);
    }

    private void bfs(TreeNode root, List<Integer> pre){
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            var node = st.pop();
            pre.add(node.val);
            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);
        }
    }
}
