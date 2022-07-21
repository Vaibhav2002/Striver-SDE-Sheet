package binarySearch;

import java.util.Arrays;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/chess-tournament_981299">Problem</a>
 **/
public class ChessTournament {
    public static int chessTournament(int[] positions, int n, int c) {
        Arrays.sort(positions);
        int l = 1, u = positions[n-1] - positions[0];
        while(l<=u){
            int mid = l+(u-l)/2;
            if(isPossible(positions, mid, c))
                l = mid+1;
            else u = mid-1;
        }
        return u;
    }

    private static boolean isPossible(int[] pos, int minDist, int n) {
        int cur = pos[0];
        n--;
        for (int i = 1; i < pos.length; i++) {
            if (pos[i] - cur >= minDist) {
                cur = pos[i];
                n--;
                if(n == 0) return true;
            }
        }
        return n < 0;
    }
}
