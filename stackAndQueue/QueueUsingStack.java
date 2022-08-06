package stackAndQueue;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> s1, s2;

    public QueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if(s2.isEmpty()) shift();
        return s2.pop();
    }

    public int peek() {
        if(s2.isEmpty()) shift();
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private void shift(){
        while(!s1.isEmpty()) s2.push(s1.pop());
    }
}
