package array3;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/unique-paths/">Problem</a>
 **/
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] i : dp) Arrays.fill(i, -1);
        return tabulation(m, n, dp);
    }

    private int memoization(int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (i == 1 || j == 1 || (i == 0 && j == 0)) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        int top = memoization(i - 1, j, dp);
        int left = memoization(i, j - 1, dp);
        return dp[i][j] = top + left;
    }

    private int tabulation(int m, int n, int[][] dp) {
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < dp.length; i++) dp[i][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
        return dp[m - 1][n - 1];
    }

}
