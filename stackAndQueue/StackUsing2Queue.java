package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queue {

    Queue<Integer> que1, que2;

    public StackUsing2Queue() {
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
    }

    public void push(int x) {
        if(!que1.isEmpty()) que1.add(x);
        else que2.add(x);
    }

    public int pop() {
        if(!que1.isEmpty()) {
            shift(que1, que2);
            return que1.remove();
        }
        else {
            shift(que2, que1);
            return que2.remove();
        }
    }

    public int top() {
        if(!que1.isEmpty()) {
            shift(que1, que2);
            int data = que1.remove();
            que2.add(data);
            return data;
        }
        else {
            shift(que2, que1);
            int data = que2.remove();
            que1.add(data);
            return data;
        }
    }

    public boolean empty() {
        return que1.isEmpty() && que2.isEmpty();
    }

    private void shift(Queue<Integer> from, Queue<Integer> to){
        while(from.size()>1) to.add(from.poll());
    }

    public static void main(String[] args) {
        StackUsing2Queue ob = new StackUsing2Queue();
        ob.push(1);
        ob.push(2);
        System.out.println(ob.top());
        System.out.println(ob.pop());
        System.out.println(ob.empty());
    }
}
