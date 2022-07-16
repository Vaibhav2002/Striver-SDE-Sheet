package recursion;

import java.util.LinkedList;

/**
* <a href="https://leetcode.com/problems/permutation-sequence/">Problem</a>
**/
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        var list = new LinkedList<Integer>();
        int fact = 1;
        for(int i = 1;i<n;i++){
            fact*=i;
            list.add(i);
        }
        list.add(n);
        k--;
        StringBuilder ans = new StringBuilder();
        while(true){
            ans.append(list.get(k/fact));
            list.remove(k/fact);
            if(list.size() == 0) break;
            k = k%fact;
            fact/=list.size();
        }
        return ans.toString();
    }
}
