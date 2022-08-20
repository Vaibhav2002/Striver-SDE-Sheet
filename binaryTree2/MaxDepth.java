package binaryTree2;

import binaryTree1.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
* <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Problem</a>
**/
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return dfs(root);
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }

    private int bfs(TreeNode root){
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int depth = 0;
        while(!que.isEmpty()){
            int len = que.size();
            for(int i = 0;i<len;i++){
                var node = que.poll();
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
            depth++;
        }
        return depth;
    }
}
