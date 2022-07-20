package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://leetcode.com/problems/subsets-ii/">Problem</a>
 **/
public class Subsets2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(new Subsets2().subsetsWithDup(a));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        fill(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void fill(int i, int[] nums, List<Integer> set, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(set));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) continue;
            set.add(nums[j]);
            fill(j + 1, nums, set, ans);
            set.remove(set.size() - 1);
        }
    }
}
