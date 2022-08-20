package binaryTree2;

import binaryTree1.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">Problem</a>
 **/
public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        bfs(root, ans);
        return ans;
    }

    private void bfs(TreeNode root, List<List<Integer>> ans) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        boolean isRev = false;
        while (!que.isEmpty()) {
            int len = que.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0;i<len;i++){
                var node = que.poll();
                addChildren(node, que);
                if(!isRev) subList.add(node.val);
                else subList.add(0, node.val);
            }
            ans.add(subList);
            isRev=!isRev;
        }
    }

    private void addChildren(TreeNode root, Queue<TreeNode> que) {
        if (root.left != null) que.add(root.left);
        if (root.right != null) que.add(root.right);
    }

    public static void main(String[] args) {
        ZigZagLevelOrder ob = new ZigZagLevelOrder();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(9);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(ob.zigzagLevelOrder(root));
    }
}
