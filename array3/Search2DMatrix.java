package array3;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/">Problem</a>
 **/
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int l = 0, u = n * m - 1;
        while (l <= u) {
            int mid = l + (u - l) / 2;
            if (matrix[mid / m][mid % m] == target) return true;
            if (matrix[mid / m][mid % m] > target) u = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
