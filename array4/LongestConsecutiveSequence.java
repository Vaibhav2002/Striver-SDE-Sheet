package array4;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence/">Problem</a>
 **/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for (int i : nums) set.add(i);
        int ans = 0;
        for (int i : nums) {
            if (set.contains(i - 1)) continue;
            int j = i;
            while (set.contains(j)) j++;
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
