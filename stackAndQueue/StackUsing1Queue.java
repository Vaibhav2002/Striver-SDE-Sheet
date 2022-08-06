package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing1Queue {
    Queue<Integer> que;

    public StackUsing1Queue() {
        que = new LinkedList<>();
    }

    public void push(int x) {
        que.add(x);
        reverse();
    }

    public int pop() {
        return que.remove();
    }

    public int top() {
        return que.peek();
    }

    public boolean empty() {
        return que.isEmpty();
    }

    private void reverse() {
        int size = que.size();
        while (size-- > 1)
            que.add(que.remove());
    }
}
