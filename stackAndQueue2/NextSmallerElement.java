package stackAndQueue2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
* <a href="https://www.codingninjas.com/codestudio/problems/1112581">Problem</a>
**/
public class NextSmallerElement {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() >= arr.get(i)) st.pop();
            int val = st.isEmpty()?-1:st.peek();
            ans.add(val);
            st.add(arr.get(i));
        }
        Collections.reverse(ans);
        return ans;
    }
}
