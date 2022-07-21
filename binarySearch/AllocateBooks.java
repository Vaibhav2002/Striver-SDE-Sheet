package binarySearch;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/ayush-gives-ninjatest_1097574">Problem</a>
 **/
public class AllocateBooks {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        long[] sumAndMin = getSumAndMin(time);
        long l = sumAndMin[1], u = sumAndMin[0];
        while(l<=u){
            long mid = l+(u-l)/2;
            if(isPossible(mid, n, time))
                u = mid - 1;
            else l = mid+1;
        }
        return l;
    }

    private static long[] getSumAndMin(int[] a){
        long min = Integer.MAX_VALUE, sum = 0;
        for(int i :a) {
            sum+= i;
            min = Math.min(min, i);
        }
        return new long[]{sum, min};
    }

    private static boolean isPossible(long threshold, int n, int[] time) {
        long sum = 0;
        for (int i : time) {
            if (i > threshold) return false;
            if (sum + i > threshold) {
                n--;
                sum = i;
            }
            else sum+=i;
        }
        return n>0;
    }
}
