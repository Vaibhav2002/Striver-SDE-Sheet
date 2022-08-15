package stackAndQueue2;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">Problem</a>
 **/
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int[] prev = getPrevMin(heights), post = getPostMin(heights);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int hd = (i - prev[i]) + (post[i] - i) - 1;
            int area = heights[i] * hd;
            ans = Math.max(ans, area);
        }
        return ans;
    }

    private int[] getPrevMin(int[] heights) {
        int[] prev = new int[heights.length];
        prev[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int j = i-1;
            while (j>=0 && heights[j] >= heights[i]) j = prev[j];
            prev[i] = j;
        }
        return prev;
    }

    private int[] getPostMin(int[] heights) {
        int n = heights.length;
        int[] post = new int[n];
        post[n-1] = n;
        for (int i = n - 1; i >= 0; i--) {
            int j = i+1;
            while (j<n && heights[j] >= heights[i]) j = post[j];
            post[i] = j;
        }
        return post;
    }
}


