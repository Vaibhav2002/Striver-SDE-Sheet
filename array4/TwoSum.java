package array4;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/two-sum/">Problem</a>
 **/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
