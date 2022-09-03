package binarySearchTree;

import binaryTree1.Node;

import java.util.ArrayList;

public class PredecessorAndSuccessorInBST {

    private static class Res {
        Node pre, succ;
    }

    public static void findPreSuc(Node root, Res p, Res s, int key) {
        efficient(root, p, s, key);
    }

    private static void efficient(Node root, Res p, Res s, int key) {
        findSuccessor(root, s, key);
        findPredecessor(root, p, key);
    }

    private static void findSuccessor(Node root, Res s, int k) {
        if (root == null) return;
        if (root.data > k) {
            s.succ = root;
            findSuccessor(root.left, s, k);
        } else findSuccessor(root.right, s, k);
    }

    private static void findPredecessor(Node root, Res p, int k) {
        if (root == null) return;
        if (root.data < k) {
            p.pre = root;
            findPredecessor(root.right, p, k);
        } else findPredecessor(root.left, p, k);
    }

    private static void brute(Node root, Res p, Res s, int key) {
        ArrayList<Node> in = new ArrayList<>();
        inorder(root, in);
        int index = search(in, key);
        if (index > 0) p.pre = in.get(index - 1);
        if (index < in.size() - 1) s.succ = in.get(index + 1);
    }

    private static void inorder(Node root, ArrayList<Node> in) {
        if (root == null) return;
        inorder(root.left, in);
        in.add(root);
        inorder(root.right, in);
    }

    private static int search(ArrayList<Node> in, int target) {
        int l = 0, u = in.size() - 1;
        while (l < u) {
            int mid = l + (u - l) / 2;
            if (in.get(mid).data == target) return mid;
            if (in.get(mid).data < target) l = mid + 1;
            else u = mid - 1;
        }
        return -1;
    }
}
