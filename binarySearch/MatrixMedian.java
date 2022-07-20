package binarySearch;

import java.util.ArrayList;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/873378">Problem</a>
 **/
public class MatrixMedian {

    private static int findLesserThanEqualCount(ArrayList<Integer> nums, int target) {
        int l = 0, u = nums.size() - 1;
        while (l <= u) {
            int mid = l + (u - l) / 2;
            if (nums.get(mid) <= target) l = mid + 1;
            else u = mid - 1;
        }
        return l;
    }

    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        int total = matrix.size() * matrix.get(0).size();
        int l = 0, u = 100000;
        while (l <= u) {
            int mid = l + (u - l) / 2;
            int count = 0;
            for (ArrayList<Integer> row : matrix) count += findLesserThanEqualCount(row, mid);
            if (count <= total / 2) l = mid + 1;
            else u = mid - 1;
        }
        return l;
    }
}
