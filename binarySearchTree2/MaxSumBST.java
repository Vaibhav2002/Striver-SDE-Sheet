package binarySearchTree2;

import binaryTree1.TreeNode;

/**
 * <a href="https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/">Problem</a>
 **/
public class MaxSumBST {

    private static class NodeVal {
        int sum, min, max;

        public NodeVal(int sum) {
            this.sum = sum;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }

        public NodeVal(int sum, int min, int max) {
            this.sum = sum;
            this.min = min;
            this.max = max;
        }

        static NodeVal getInvalidNode() {
            return new NodeVal(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    private int ans;

    public int maxSumBST(TreeNode root) {
        ans = 0;
        compute(root);
        return ans;
    }

    private NodeVal compute(TreeNode root) {
        if (root == null) return new NodeVal(0);
        NodeVal left = compute(root.left);
        NodeVal right = compute(root.right);
        if (root.val > left.max && root.val < right.min){
            int sum = root.val+left.sum+right.sum;
            ans = Math.max(ans, sum);
            return new NodeVal(
                    sum,
                    Math.min(left.min, root.val),
                    Math.max(right.max, root.val)
            );
        }
        else return NodeVal.getInvalidNode();
    }
}
