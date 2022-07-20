package linkedListAndArray;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Problem</a>
 **/
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int i = 0, j = 0;
        while (++j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
