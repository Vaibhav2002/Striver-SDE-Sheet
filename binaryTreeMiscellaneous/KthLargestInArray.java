package binaryTreeMiscellaneous;

import java.util.PriorityQueue;

public class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:nums){
            if(pq.size() < k) pq.offer(i);
            else if(pq.peek() < i){
                pq.poll();
                pq.offer(i);
            }
        }
        return pq.peek();
    }
}
