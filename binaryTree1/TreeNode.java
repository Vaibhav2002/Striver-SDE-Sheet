package binaryTree1;

/**
 * Node object used in LeetCode Problems
 */
public class TreeNode {
    public int val;
    public TreeNode left, right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

