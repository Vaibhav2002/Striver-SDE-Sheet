package recursion;

import java.util.ArrayList;

/**
* <a href="https://practice.geeksforgeeks.org/problems/subset-sums2234/1">Problem</a>
**/
public class SubsetSum {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        var ans = new ArrayList<Integer>();
        fill(arr, N - 1, 0, ans);
        return ans;
    }

    private void fill(ArrayList<Integer> a, int i, int sum, ArrayList<Integer> sums){
        if(i < 0) {
            sums.add(sum);
            return;
        }
        fill(a, i-1, sum+a.get(i), sums);
        fill(a, i-1, sum, sums);
    }
}
