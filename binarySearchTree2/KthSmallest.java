package binarySearchTree2;

import binaryTree1.TreeNode;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
* <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">Problem</a>
**/
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        return iterative(root, k);
    }

    private int iterative(TreeNode root, int k) {
        TreeNode temp = root;
        var st = new Stack<TreeNode>();
        while (temp != null || st.isEmpty()) {
            while (temp != null) {
                st.push(temp);
                temp = temp.left;
            }
            temp = st.pop();
            if(--k == 0) return temp.val;
            temp = temp.right;
        }
        return -1;
    }

    private void recur(TreeNode root, AtomicInteger k, AtomicInteger kth) {
        if (root == null || k.get() < 0) return;
        recur(root.left, k, kth);
        if (k.decrementAndGet() == 0) kth.set(root.val);
        recur(root.right, k, kth);
    }
}
