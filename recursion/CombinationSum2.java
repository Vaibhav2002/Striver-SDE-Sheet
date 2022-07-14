package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* <a href="https://leetcode.com/problems/combination-sum-ii/">Problem</a>
**/
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        fill(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void fill(int i, int[] a, int target, List<Integer> set, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(set));
            return;
        }
        for(int j = i;j<a.length;j++){
            if(j>i && a[j] == a[j-1]) continue;
            if(a[j]>target) break;
            set.add(a[j]);
            fill(j+1,a, target - a[j], set, ans);
            set.remove(set.size() - 1);
        }
    }
}
