package array2;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/">Problem</a>
 **/
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        return optimal(nums);
    }

    /**
     * Uses The tortoise and hare approach
     * TC - O(N) SC - (1)
     */
    private int optimal(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * Using HashMap to calculate frequency of each element
     * Returns element which has freq > 1
     * TC - O(N) SC - O(N)
     */
    private int mapApproach(int[] nums) {
        var freq = new HashMap<Integer, Integer>();
        for (int i : nums) freq.merge(i, 1, Integer::sum);
        for (Map.Entry<Integer, Integer> entry : freq.entrySet())
            if (entry.getValue() > 1) return entry.getKey();
        return -1;
    }
}
