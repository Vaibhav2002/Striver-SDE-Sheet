package greedy;

import java.util.Arrays;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#">Problem</a>
 **/
public class MinimumPlatforms {
    static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int ans = 0, platforms = 1;
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }
            ans = Math.max(ans, platforms);
        }
        return ans;
    }
}
