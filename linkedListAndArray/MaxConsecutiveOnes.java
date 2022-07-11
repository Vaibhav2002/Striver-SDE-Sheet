package linkedListAndArray;

/**
* <a href="https://leetcode.com/problems/max-consecutive-ones/">Problem</a>
**/
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count =0, ans = 0;
        for(int i:nums){
            if(i == 0) {
                ans = Math.max(ans, count);
                count = 0;
            }
            else count++;
        }
        return ans;
    }
}
