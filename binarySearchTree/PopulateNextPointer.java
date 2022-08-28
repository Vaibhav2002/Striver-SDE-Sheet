package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
* <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">Problem</a>
**/
public class PopulateNextPointer {
    private static class Node {
        public int val;
        public Node left,right, next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        iterative(root);
        return root;
    }

    private void iterative(Node root){
        if(root == null) return;
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int len = que.size();
            for(int i= 0;i<len;i++){
                var node = que.poll();
                if(i!=len - 1) node.next = que.peek();
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
        }
    }

    private void recur(Node root){
        if(root == null) return;
        if(root.left!=null) root.left.next = root.right;
        if(root.right!=null && root.next!=null) root.right.next = root.next.left;
        recur(root.left);
        recur(root.right);
    }
}
