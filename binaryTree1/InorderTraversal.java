package binaryTree1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">Problem</a>
**/
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        dfs(root, inorder);
        return inorder;
    }

    private void dfs(TreeNode root, List<Integer> inorder){
        if(root == null) return;
        dfs(root.left, inorder);
        inorder.add(root.val);
        dfs(root.right, inorder);
    }


    private void bfs(TreeNode root, List<Integer> inorder){
        Stack<TreeNode> st = new Stack<>();
        TreeNode temp = root;
        while(temp!=null || !st.isEmpty()){
            while(temp!=null) {
                st.push(temp);
                temp = temp.left;
            }
            temp = st.pop();
            inorder.add(temp.val);
            temp = temp.right;
        }
    }
}
