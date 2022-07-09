package array4;

import java.util.ArrayList;
import java.util.HashMap;

/**
* <a href="https://www.codingninjas.com/codestudio/problems/1115652?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website">Problem</a>
**/
public class CountSubArrayXOR {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        int xor = 0, count = 0;
        var map = new HashMap<Integer, Integer>();
        for(int i:arr){
            xor^=i;
            if(xor == x) count++;
            if(map.containsKey(xor^x)) count+= map.get(xor^x);
            map.merge(xor, 1, Integer::sum);
        }
        return count;
    }
}
