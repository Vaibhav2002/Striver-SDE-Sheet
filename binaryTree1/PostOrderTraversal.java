package binaryTree1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">Problem</a>
**/
public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> post = new ArrayList<>();
        bfs(root, post);
        return post;
    }

    private void dfs(TreeNode root, List<Integer> post){
        if(root == null)return;
        post.add(root.val);
        dfs(root.left, post);
        dfs(root.right, post);
    }

    private void bfs(TreeNode root, List<Integer> post){
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> res = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            var node = st.pop();
            res.push(node.val);
            if(node.left != null) st.push(node.left);
            if(node.right != null) st.push(node.right);
        }
        while(!res.isEmpty()) post.add(res.pop());
    }
}
