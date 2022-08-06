package stackAndQueue;

import java.util.HashMap;
import java.util.Stack;

/**
* <a href="https://leetcode.com/problems/next-greater-element-i/">Problem</a>
**/
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> greater = new HashMap<>();
        Stack<Integer> nextGreater = new Stack<>();
        for(int i = nums2.length - 1;i>=0;i--){
            while(!nextGreater.isEmpty() && nextGreater.peek() < nums2[i])
                nextGreater.pop();
            int next = nextGreater.isEmpty()?-1:nextGreater.peek();
            greater.put(nums2[i], next);
            nextGreater.push(nums2[i]);
        }
        for(int i=0;i< nums1.length;i++) nums1[i] = greater.get(nums1[i]);
        return nums1;
    }
}
