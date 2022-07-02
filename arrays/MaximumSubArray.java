package arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/">Problem</a>
 **/
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0], ans = nums[0];
        for (int i = 1;i<nums.length;i++) {
            max = Math.max(max + nums[i], nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
