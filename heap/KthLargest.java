package heap;

import java.util.PriorityQueue;

/**
* <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Problem</a>
**/
public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:nums){
            pq.add(i);
            if(pq.size()>k) pq.poll();
        }
        return pq.poll();
    }
}
