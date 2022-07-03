package array1;

/**
 * <a href="https://leetcode.com/problems/next-permutation/">Problem</a>
 **/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2, j = n-1;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0){
            while(j>=0 && nums[j]<=nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
    }

    private void reverse(int[] a, int start, int end) {
        while(start<end){
            swap(a, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
