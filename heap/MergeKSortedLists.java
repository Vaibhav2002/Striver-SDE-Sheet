package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(ArrayList<Integer> i:kArrays)
            pq.addAll(i);
        while(!pq.isEmpty())
            ans.add(pq.poll());
        return ans;
    }
}
