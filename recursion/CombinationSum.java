package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://leetcode.com/problems/combination-sum/">Problem</a>
 **/
public class CombinationSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int target = sc.nextInt();
        System.out.println(new CombinationSum().combinationSum(a, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        fill(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void fill(int i, int[] a, int target, List<Integer> set, List<List<Integer>> ans) {
        if (i == a.length) {
            if (target == 0)
                ans.add(new ArrayList<>(set));
            return;
        }
        if (target >= a[i]) {
            set.add(a[i]);
            fill(i, a, target - a[i], set, ans);
            set.remove(set.size() - 1);
        }
        fill(i + 1, a, target, set, ans);
    }
}
