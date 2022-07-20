package array4;

import java.util.HashMap;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1#_=_">Problem</a>
 **/
public class LargestSubArray0Sum {
    int maxLen(int[] arr, int n) {
        var map = new HashMap<Integer, Integer>();
        int sum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) ans = Math.max(ans, i + 1);
            if (map.containsKey(sum))
                ans = Math.max(ans, i - map.get(sum));
            else map.put(sum, i);
        }
        return ans;
    }
}
