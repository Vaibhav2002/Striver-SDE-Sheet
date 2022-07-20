package array3;

/**
 * <a href="https://leetcode.com/problems/majority-element/">Problem</a>
 **/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = getCandidate(nums);
        return isMajority(nums, candidate) ? candidate : -1;
    }

    private int getCandidate(int[] a) {
        int count = 1, candidate = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] == candidate) count++;
            else count--;
            if (count == 0) candidate = a[i];
        }
        return candidate;
    }

    private boolean isMajority(int[] a, int candidate) {
        int freq = 0;
        for (int i : a) if (candidate == i) freq++;
        return freq > a.length / 2;
    }
}
