package stackAndQueue;

interface Stack {
    void push(int data) throws Exception;

    int pop() throws Exception;

    int peek() throws Exception;
}

public class ArrayStack implements Stack{

    int[] stack;
    int size, top;

    ArrayStack(int n) {
        size = n;
        stack = new int[n];
        top = -1;
    }

    @Override
    public void push(int data) throws Exception {
        if(top == size-1) throw new Exception("Stack is full");
        stack[++top] = data;
    }

    @Override
    public int pop() throws Exception {
        if(top == -1) throw new Exception("Stack is empty");
        return stack[top--];
    }

    @Override
    public int peek() throws Exception {
        if(top == -1) throw new Exception("Stack is empty");
        return stack[top];
    }
}
