package binarySearchTree2;

import binaryTree1.Node;
import binaryTree1.TreeNode;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class KthLargest {

    public int kthLargest(Node root, int K) {
        var kth = new AtomicInteger();
        recur(root, new AtomicInteger(K), kth);
        return kth.get();
    }

    private int iterative(Node root, int k) {
        Node temp = root;
        var st = new Stack<Node>();
        while (temp != null || !st.isEmpty()) {
            while (temp != null) {
                st.push(temp);
                temp = temp.right;
            }
            temp = st.pop();
            if (--k == 0) return temp.data;
            temp = temp.left;
        }
        return -1;
    }

    private void recur(Node root, AtomicInteger k, AtomicInteger kth) {
        if (root == null || k.get() < 0) return;
        recur(root.right, k, kth);
        if (k.decrementAndGet() == 0) kth.set(root.data);
        recur(root.left, k, kth);
    }
}
