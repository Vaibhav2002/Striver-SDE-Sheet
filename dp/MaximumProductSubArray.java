package dp;

/**
* <a href="https://leetcode.com/problems/maximum-product-subarray/description/">Problem</a>
**/
public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        return kadane(nums);
    }

    private int kadane(int[] nums){
        int ans = nums[0];
        int max = nums[0], min = nums[0];
        for(int i:nums){
            if(i < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(i, max*i);
            min = Math.min(i, min*i);
            ans = Math.max(min, max);
        }
        return ans;
    }

    private int twoPointer(int[] nums){
        int l = 1, u = 1;
        int ans = nums[0];
        int n = nums.length;
        for(int i = 0; i<n ;i++){
            if(l == 0) l = 1;
            if(u == 0) u = 1;

            l *= nums[i];
            u *= nums[n-i-1];

            ans = Math.max(ans, Math.max(l, u));
        }
        return ans;
    }
}
