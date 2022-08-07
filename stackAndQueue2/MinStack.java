package stackAndQueue2;

import java.util.Stack;

/**
* <a href="https://leetcode.com/problems/min-stack/">Problem</a>
**/
public class MinStack {

    Stack<Integer> st, min;

    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if(min.isEmpty()) min.push(val);
        else min.push(Math.min(min.peek(), val));
    }

    public void pop() {
        st.pop();
        min.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
