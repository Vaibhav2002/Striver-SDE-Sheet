package binaryTreeMiscellaneous;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <a href="https://www.interviewbit.com/problems/distinct-numbers-in-window/">Problem</a>
 **/
public class DistinctCountInKWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (B > A.size()) return ans;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < B; i++) freq.merge(A.get(i), 1, Integer::sum);
        ans.add(freq.size());
        for(int i = B;i<A.size();i++){
            int oldNumber = A.get(i - B), oldValue = freq.get(oldNumber);
            if(oldValue == 1) freq.remove(oldNumber);
            else freq.put(oldNumber, oldValue-1);

            freq.merge(A.get(i), 1, Integer::sum);
            ans.add(freq.size());
        }
        return ans;
    }
}
