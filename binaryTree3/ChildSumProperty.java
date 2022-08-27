package binaryTree3;

import binaryTree1.TreeNode;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/childrensumproperty_790723">Problem</a>
 **/
public class ChildSumProperty {
    private static class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }
    public static void changeTree(BinaryTreeNode<Integer> root) {
        childSum(root);
    }

    private static int childSum(BinaryTreeNode<Integer> root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.data;
        int sum = 0;
        if(root.left!=null) sum+=root.left.data;
        if(root.right!=null) sum+=root.right.data;
        if(root.data > sum){
            if(root.left!=null) root.left.data = root.data;
            if(root.right!=null) root.right.data = root.data;
        }
        else root.data = sum;
        int left = childSum(root.left), right = childSum(root.right);
        root.data = left+right;
        return root.data;
    }
}
