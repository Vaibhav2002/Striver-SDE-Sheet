package binaryTree1;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">Problem</a>
 **/
public class MorrisInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        if (root == null) return inorder;
        morrisTraversal(root, inorder);
        return inorder;
    }

    private void morrisTraversal(TreeNode root, List<Integer> inorder) {
        TreeNode cur = root;
        while(cur!=null){
            if (cur.left != null) {
                var rightMost = getRightMostChild(cur.left, cur);
                rightMost.right = (rightMost.right == cur) ? null : cur;
                if(rightMost.right != null)
                    cur = cur.left;
                else {
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
            else{
                inorder.add(cur.val);
                cur = cur.right;
            }
        }
    }

    private TreeNode getRightMostChild(TreeNode cur, TreeNode root) {
        TreeNode temp = cur;
        while (temp.right != null && temp.right != root) temp = temp.right;
        return temp;
    }
}
