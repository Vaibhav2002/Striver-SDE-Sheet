package binarySearch;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">Problem</a>
 **/
public class SearchInRotatedSorted {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (target > nums[0]) return search(nums, 0, pivot - 1, target);
        else return search(nums, pivot, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        int l = start, u = end;
        while (l <= u) {
            int mid = l + (u - l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else u = mid - 1;
        }
        return -1;
    }

    private int findPivot(int[] nums) {
        int n = nums.length;
        int l = 0, u = n - 1;
        while (l < u) {
            int mid = l + (u - l) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) return mid;
            if (mid < n - 1 && nums[mid] > nums[mid + 1]) return mid + 1;
            if (nums[mid] < nums[0])
                u = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}
