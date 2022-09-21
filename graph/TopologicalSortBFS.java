package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
* <a href="https://practice.geeksforgeeks.org/problems/topological-sort/1">Problem</a>
**/
public class TopologicalSortBFS {

    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj)
    {
        int[] topo= new int[v], inorder = getInOrder(adj, v);
        int index = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0;i<v;i++) if(inorder[i] == 0) que.add(i);
        while(!que.isEmpty()){
            var node = que.poll();
            topo[index++] = node;
            for(Integer next:adj.get(node)){
                if(--inorder[next] == 0)
                    que.add(next);
            }
        }
        return topo;

    }

    private static int[] getInOrder(ArrayList<ArrayList<Integer>> adj, int v){
        int[] inOrder = new int[v];
        for(ArrayList<Integer> edges:adj)
            for(Integer dest:edges) inOrder[dest]++;
        return inOrder;
    }
}
