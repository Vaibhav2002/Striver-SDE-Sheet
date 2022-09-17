package binaryTreeMiscellaneous;

import java.util.PriorityQueue;

public class KthLargestInStream {

    PriorityQueue<Integer> stream;
    int k;

    public KthLargestInStream(int k, int[] nums) {
        stream = new PriorityQueue<>();
        for (int i : nums) {
            add(i);
        }
        this.k = k;
    }

    public int add(int val) {
        stream.add(val);
        if(stream.size() > k) stream.poll();
        return stream.peek();
    }
}
