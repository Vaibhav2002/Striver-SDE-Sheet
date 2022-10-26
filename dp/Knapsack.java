package dp;

import java.util.Arrays;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1">Problem</a>
 **/
public class Knapsack {
    static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n+1][W+1];
        for(int[] i:dp) Arrays.fill(i, -1);
        return find(n - 1, W, wt, val, dp);
    }

    private static int find(int i, int w, int[] wt, int[] val, int[][] dp) {
        if (i < 0 || w == 0) return 0;
        if (dp[i][w] != -1) return dp[i][w];
        int max = find(i - 1, w, wt, val, dp);
        if (w >= wt[i]) {
            max = Math.max(max, val[i] + find(i - 1, w - wt[i], wt, val, dp));
        }
        return dp[i][w] = max;
    }
}
