package array3;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/majority-element-ii/">Problem</a>
 **/
public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        var candidates = getCandidates(nums);
        return getMajority(candidates, nums);
    }

    private List<Integer> getCandidates(int[] nums) {
        int count1 = 0, count2 = 0, ele1 = -1, ele2 = -1;
        for (int i : nums) {
            if (i == ele1) count1++;
            else if (i == ele2) count2++;
            else if (count1 == 0) {
                ele1 = i;
                count1 = 1;
            } else if (count2 == 0) {
                ele2 = i;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        return List.of(ele1, ele2);
    }

    private List<Integer> getMajority(List<Integer> candidates, int[] a) {
        int freq1 = 0, freq2 = 0;
        for (int i : a) {
            if (i == candidates.get(0)) freq1++;
            else if (i == candidates.get(1)) freq2++;
        }
        List<Integer> majority = new ArrayList<>();
        if (freq1 > a.length / 3) majority.add(candidates.get(0));
        if (freq2 > a.length / 3) majority.add(candidates.get(1));
        return majority;
    }
}
