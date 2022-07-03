package array1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://leetcode.com/problems/sort-colors/">Problem</a>
 **/
public class SortColors {
    public void sortColors(int[] a) {
        int l = 0, mid = 0, u = a.length - 1;
        while (mid <= u) {
            switch (a[mid]) {
                case 0 -> {
                    swap(a, l, mid);
                    l++;
                    mid++;
                }
                case 1 -> mid++;
                case 2 -> {
                    swap(a, mid, u);
                    u--;
                }
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++) a[i] = sc.nextInt();
        new SortColors().sortColors(a);
        System.out.println(Arrays.toString(a));
    }
}
