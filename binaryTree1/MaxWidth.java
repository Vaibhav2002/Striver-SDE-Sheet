package binaryTree1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/maximum-width-of-binary-tree/">Problem</a>
 **/
public class MaxWidth {

    private static class NodeWithIndex {
        TreeNode node;
        int index;

        public NodeWithIndex(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }

        public NodeWithIndex getLeftChild() {
            return new NodeWithIndex(node.left, index * 2 + 1);
        }

        public NodeWithIndex getRightChild() {
            return new NodeWithIndex(node.right, index * 2 + 2);
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<NodeWithIndex> que = new LinkedList<>();
        que.add(new NodeWithIndex(root, 1));
        int ans = Integer.MIN_VALUE;
        while (!que.isEmpty()) {
            int len = que.size();
            int first = que.peek().index, last = first;
            for (int i = 0; i < len; i++) {
                var node = que.poll();
                addChildren(node, que);
                last = node.index+1;
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    private void addChildren(NodeWithIndex node, Queue<NodeWithIndex> que) {
        node.index--;
        if (node.node.left != null) que.add(node.getLeftChild());
        if (node.node.right != null) que.add(node.getRightChild());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        MaxWidth ob = new MaxWidth();
        System.out.println(ob.widthOfBinaryTree(root));
    }
}
