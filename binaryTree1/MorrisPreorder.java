package binaryTree1;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) return preOrder;
        morrisTraversal(root, preOrder);
        return preOrder;
    }

    private void morrisTraversal(TreeNode root, List<Integer> preOrder) {
        TreeNode cur = root;
        while(cur!=null){
            if (cur.left != null) {
                var rightMost = getRightMostChild(cur.left, cur);
                rightMost.right = (rightMost.right == cur) ? null : cur;
                if(rightMost.right != null) {
                    preOrder.add(cur.val);
                    cur = cur.left;
                }
                else cur = cur.right;
            }
            else{
                preOrder.add(cur.val);
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
