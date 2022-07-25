package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/">Problem</a>
 **/
public class TopKFreq {
    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int i : nums) map.merge(i, 1, Integer::sum);
        var pq = new PriorityQueue<Map.Entry<Integer, Integer>>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) pq.poll();
        }
        int[] ans = new int[k];
        int index = 0;
        while (!pq.isEmpty())
            ans[index++] = pq.poll().getKey();
        return ans;
    }
}
