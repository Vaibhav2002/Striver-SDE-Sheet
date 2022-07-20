package linkedListAndArray;

import java.util.Scanner;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/">Problem</a>
 **/
public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) height[i] = sc.nextInt();
        System.out.println(new TrappingRainWater().trap(height));
    }

    public int trap(int[] height) {
        int ans = 0;
        int[] prefix = getPrefix(height), postfix = getPostfix(height);
        for (int i = 0; i < height.length; i++)
            ans += Math.min(prefix[i], postfix[i]) - height[i];
        return ans;
    }

    private int[] getPrefix(int[] height) {
        int[] prefix = new int[height.length];
        prefix[0] = height[0];
        for (int i = 1; i < height.length; i++) prefix[i] = Math.max(prefix[i - 1], height[i]);
        return prefix;
    }

    private int[] getPostfix(int[] height) {
        int[] postfix = new int[height.length];
        postfix[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) postfix[i] = Math.max(postfix[i + 1], height[i]);
        return postfix;
    }
}
