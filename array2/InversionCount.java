package array2;

import java.util.Arrays;
import java.util.Scanner;

public class InversionCount {
    private static long count = 0;
    public static long getInversions(long arr[], int n) {
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        return count;
    }

    private static long[] mergeSort(long a[]){
        if(a.length == 1) return a;
        int mid = a.length/2;
        long[] left = Arrays.copyOfRange(a, 0, mid);
        long[] right = Arrays.copyOfRange(a, mid, a.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }
    private static long[] merge(long[] a, long[] b){
        long[] c = new long[a.length+b.length];
        int i = 0, j = 0, k =0;
        while(i<a.length&& j<b.length){
            if(b[j]<a[i]) {
                count+=a.length - i;
                c[k++] = b[j++];
            }
            else c[k++] = a[i++];
        }
        while(i<a.length) c[k++] = a[i++];
        while(j<b.length) c[k++] = b[j++];
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextLong();
        InversionCount.getInversions(a, n);
        System.out.println(InversionCount.count);
    }
}
