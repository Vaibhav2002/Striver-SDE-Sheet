package array4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                var l = find(i, j, nums, (long) target - nums[i] - nums[j]);
                ans.addAll(l);
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) ++j;
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) ++i;
        }
        return ans;
    }

    private List<List<Integer>> find(int a, int b, int[] nums, long target) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = b + 1, j = nums.length - 1;
        while (i < j) {
            long sum = (long) nums[i] + (long) nums[j];
            if (sum == target) {
                var l = List.of(nums[a], nums[b], nums[i], nums[j]);
                ans.add(l);
                while (i < j && nums[i] == l.get(2)) ++i;
                while (i < j && nums[j] == l.get(3)) --j;
            } else if (sum < target) i++;
            else j--;
        }
        return ans;
    }
}
