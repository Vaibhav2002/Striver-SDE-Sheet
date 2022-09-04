package binarySearchTree2;

import binaryTree1.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/two-sum-iv-input-is-a-bst/">Problem</a>
 **/
public class TwoSum4 {

    public boolean findTarget(TreeNode root, int k) {
        return efficient(root, k);
    }

    private boolean efficient(TreeNode root, int k){
        BSTIterator inc = new BSTIterator(root), dec = new BSTIterator(root, true);
        int i = inc.next().val, j = dec.next().val;
        while(i<j){
            int sum = i+j;
            if(sum == k) return true;
            if(sum < k) i = inc.next().val;
            else j = dec.next().val;
        }
        return false;
    }

    private List<Integer> inOrder(TreeNode root) {
        var st = new Stack<TreeNode>();
        List<Integer> inOrder = new ArrayList<>();
        TreeNode temp = root;
        while (temp != null || !st.isEmpty()) {
            while (temp != null) {
                st.push(temp);
                temp = temp.left;
            }
            temp = st.pop();
            inOrder.add(temp.val);
            temp = temp.right;
        }
        return inOrder;
    }

    private boolean doesExist(List<Integer> nums, int target) {
        int l = 0, u = nums.size() - 1;
        while (l < u) {
            int sum = nums.get(l)+nums.get(u);
            if (sum == target) return true;
            if (sum < target) l++;
            else u--;
        }
        return false;
    }
}
