package array4;

import java.util.*;
import java.util.stream.Collectors;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                var l = find(i, j, nums, target - nums[i] - nums[j]);
                ans.addAll(l);
                while(j + 1 < nums.length && nums[j + 1] == nums[j]) ++j;
            }
            while(i + 1 < nums.length && nums[i + 1] == nums[i]) ++i;
        }
        return ans;
    }

    private HashSet<List<Integer>> find(int a, int b, int[] nums, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
        int i = b + 1, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                var l = List.of(nums[a], nums[b], nums[i], nums[j]);
                ans.add(l);
                while(i<j && nums[i] == l.get(2)) ++i;
                while(i<j && nums[j] == l.get(3)) ++j;
            }
            else if(nums[i]+nums[j]<target) i++;
            else j--;
        }
        return ans;
    }
}
