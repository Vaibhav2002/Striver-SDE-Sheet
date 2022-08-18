package binaryTree1;

import java.util.ArrayList;
import java.util.List;

/**
* <a href="https://www.codingninjas.com/codestudio/problems/981269">Problem</a>
**/
public class Traversal1Iteration {
    private static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<3;i++) ans.add(new ArrayList<>());
        traverse(root, ans);
        return ans;
    }

    private static void traverse(BinaryTreeNode<Integer> root, List<List<Integer>> ans){
        if(root == null)return;
        ans.get(1).add(root.data);
        traverse(root.left, ans);
        ans.get(0).add(root.data);
        traverse(root.right, ans);
        ans.get(2).add(root.data);
    }
}
