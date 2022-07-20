package binarySearch;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/1062679">Problem</a>
 **/
public class NthRoot {

    public static double findNthRootOfM(int n, long m) {
        double low = 1.0, high = (double) m, eps = 1e-6;
        while (high - low > eps) {
            double mid = low + (high - low) / 2;
            double pow = Math.pow(mid, n);
            if (high - low <= eps) return mid;
            if (pow == m) return mid;
            if (pow < m) low = mid;
            else high = mid;
        }
        return low;
    }
}
