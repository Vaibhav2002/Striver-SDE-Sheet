package binarySearchTree2;

import binaryTree1.TreeNode;

import java.util.Iterator;
import java.util.Stack;

public class BSTIterator implements Iterator<TreeNode> {

    private final Stack<TreeNode> st;
    private final boolean isReverse;

    public BSTIterator(TreeNode root) {
        this(root, false);
    }

    public BSTIterator(TreeNode root, Boolean reverse) {
        isReverse = reverse;
        st = new Stack<>();
        if (!reverse)
            fillAllLeftNodes(root);
        else fillAllRightNodes(root);
    }

    @Override
    public boolean hasNext() {
        return !st.isEmpty();
    }

    @Override
    public TreeNode next() {
        var node = st.pop();
        if (!isReverse) fillAllLeftNodes(node.right);
        else fillAllRightNodes(node.left);
        return node;
    }

    private void fillAllLeftNodes(TreeNode root) {
        TreeNode temp = root;
        while (temp != null) {
            st.push(temp);
            temp = temp.left;
        }
    }

    private void fillAllRightNodes(TreeNode root) {
        TreeNode temp = root;
        while (temp != null) {
            st.push(temp);
            temp = temp.right;
        }
    }
}
