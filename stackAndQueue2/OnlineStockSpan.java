package stackAndQueue2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* <a href="https://leetcode.com/problems/online-stock-span/">Problem</a>
**/
public class OnlineStockSpan {

    List<Integer> a;
    Stack<Integer> st;

    public OnlineStockSpan() {
        a = new ArrayList<>();
        st = new Stack<>();
    }

    public int next(int price) {
        while(!st.isEmpty() && a.get(st.peek()) <= price) st.pop();
        int index = 0;
        if(!st.isEmpty()) index = st.peek();
        a.add(price);
        st.push(a.size() - 1);
        return st.peek() - index;
    }
}
