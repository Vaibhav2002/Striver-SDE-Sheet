package binarySearch;

import java.util.PriorityQueue;

/**
* <a href="https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1">Problem</a>
**/
public class KthElementOf2Sorted {
    public long kthElement(int[] arr1, int[] arr2, int n, int m, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, j=0;
        while(pq.size()<k && (i<n || j<m)){
            if(i<n && j<m){
                int min = Math.min(arr1[i], arr2[j]);
                pq.add(min);
                if(min == arr1[i]) i++;
                else j++;
            }
            else if(i<n){
                pq.add(arr1[i]);
                i++;
            }
            else{
                pq.add(arr2[j]);
                j++;
            }
        }
        while(pq.size() > 1) pq.poll();
        return pq.poll();
    }
}
