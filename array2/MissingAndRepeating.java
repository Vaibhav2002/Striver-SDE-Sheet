package array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MissingAndRepeating {
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        long diff = sum(arr) - sumOfN(n);
        long sum = (sumSq(arr) - sumSqOfN(n)) / diff;
        int missing = (int) (sum - diff) / 2;
        int duplicate = (int) (sum - missing);
        return new int[]{missing, duplicate};
    }

    private static long sumOfN(int n) {
        return (long) n * (n + 1) / 2;
    }

    private static long sumSqOfN(int n) {
        return n * (n + 1) * (2L * n + 1) / 6;
    }

    private static long sum(ArrayList<Integer> a) {
        long sum = 0;
        for (int i : a) sum += i;
        return sum;
    }

    private static long sumSq(ArrayList<Integer> a) {
        long sum = 0;
        for (int i : a) sum += (long) i * i;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++)
            list.add(sc.nextInt());
        int[] ans = MissingAndRepeating.missingAndRepeating(list, n);
        System.out.println(Arrays.toString(ans));
    }
}
