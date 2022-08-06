package stackAndQueue;

import java.util.Arrays;

interface Queue{
    void add(int data) throws Exception;
    int remove() throws Exception;
    int peek();
    boolean isEmpty();
}

public class ArrayQueue implements Queue{

    private final int[] queue;
    private final int size;
    private int end;

    ArrayQueue(int size){
        this.size = size;
        queue = new int[size];
        end = -1;
    }

    @Override
    public void add(int data) throws Exception {
        if(end == size - 1) throw new Exception("Queue is full");
        queue[++end] = data;
    }

    @Override
    public int remove() throws Exception {
        if(end == -1) throw new Exception("Queue is empty");
        int data = queue[0];
        shift();
        return data;
    }

    @Override
    public int peek() {
        return queue[0];
    }

    @Override
    public boolean isEmpty() {
        return end == -1;
    }

    private void shift(){
        for(int i=0;i<end;i++)
            queue[i] = queue[i+1];
        end--;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
