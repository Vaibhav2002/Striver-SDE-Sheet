package binarySearch;

/**
 * <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/">Problem</a>
 **/
public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, u = nums.length - 2;
        while (l <= u) {
            int mid = l + (u - l) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) //first occurrence at correct index
                    l = mid + 1;
                else u = mid - 1;
            }
            else{
                if (nums[mid] != nums[mid + 1]) //last occurrence at correct index
                    l = mid + 1;
                else u = mid - 1;
            }
        }
        return nums[l];
    }
}
