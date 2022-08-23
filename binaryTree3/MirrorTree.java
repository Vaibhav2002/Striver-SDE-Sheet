package binaryTree3;

import binaryTree1.Node;

/**
* <a href="https://practice.geeksforgeeks.org/problems/mirror-tree/1">Problem</a>
**/
public class MirrorTree {
    void mirror(Node node) {
        invert(node);
    }

    private Node invert(Node node){
        if(node == null) return null;
        Node left = invert(node.left);
        node.left = invert(node.right);
        node.right = left;
        return node;
    }
}
