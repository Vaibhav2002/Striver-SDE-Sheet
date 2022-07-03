package array1;

import java.util.Arrays;
import java.util.Scanner;

public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        boolean isFirstColumnMarked = false;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0)isFirstColumnMarked = true;
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
            }
        }
        if (matrix[0][0] == 0) Arrays.fill(matrix[0], 0);
        if (isFirstColumnMarked) for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) matrix[i][j] = sc.nextInt();
        new SetMatrixZero().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
