package array2;

/**
* <a href="https://leetcode.com/problems/merge-sorted-array/">Problem</a>
**/
public class MergeSortedArray {

    /**
     * Uses merging algorithm similar to that used in mergeSort
     * here rather than having pointed to final array
     * ihe third pointer points to end of first array
     * Comparison is done from reverse
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while(i>=0){
            if(nums1[i]>nums2[j])
                nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
        while(j>=0) nums1[k--] = nums2[j--];
    }
}

