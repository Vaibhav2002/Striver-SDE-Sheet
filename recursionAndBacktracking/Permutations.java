package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
* <a href="https://leetcode.com/problems/permutations/">Problem</a>
**/
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        fill(nums, new ArrayList<>(), ans);
        return ans;
    }

    private void fill(int[] nums, List<Integer> cur, List<List<Integer>> ans){
        if(cur.size() == nums.length){
            ans.add(cur);
            return;
        }
        for(Integer i:nums){
            if(cur.contains(i)) continue;
            var cloned = new ArrayList<>(cur);
            cloned.add(i);
            fill(nums, cloned, ans);
        }
    }
}
