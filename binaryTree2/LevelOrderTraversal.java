package binaryTree2;

import binaryTree1.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/">Problem</a>
 **/
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) return levelOrder;
        iterative(root, levelOrder);
        return levelOrder;
    }


    private void iterative(TreeNode root, List<List<Integer>> ans) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int len = que.size();
            ans.add(new ArrayList<>());
            for (int i = 0; i < len; i++) {
                var node = que.poll();
                ans.get(ans.size() - 1).add(node.val);
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
        }
    }

    private void recursive(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) return;
        if (ans.size() <= level) ans.add(new ArrayList<>());
        ans.get(level).add(root.val);
        recursive(root.left, level + 1, ans);
        recursive(root.right, level + 1, ans);
    }
}
