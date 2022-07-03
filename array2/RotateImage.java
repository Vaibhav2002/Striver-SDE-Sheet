package array2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://leetcode.com/problems/rotate-image/">Problem</a>
 * <p>
 * Incomplete
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, i, j, j, n - i - 1);
            }
        }
    }

    private void swap(int[][] a, int i, int j, int i1, int j1) {
        int temp = a[i][j];
        a[i][j] = a[i1][j1];
        a[i1][j1] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();
        new RotateImage().rotate(a);
        System.out.println(Arrays.deepToString(a));
    }
}
