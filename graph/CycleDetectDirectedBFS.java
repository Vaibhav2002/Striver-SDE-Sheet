package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectDirectedBFS implements CycleDetect{

    @Override
    public boolean isCyclePresent(List<List<Integer>> adj, int v) {
        return checkUsingBFS(adj, v);
    }

    private boolean checkUsingBFS(List<List<Integer>> adj, int v){
        var topoSort = getTopologicalSort(adj, v);
        return topoSort.size() != v;
    }

    private List<Integer> getTopologicalSort(List<List<Integer>> adj, int v){
        List<Integer> topo = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        int[] inorder = getInOrder(adj, v);
        for(int i = 0;i<inorder.length;i++) if(inorder[i] == 0) que.add(i);
        while(!que.isEmpty()){
            var node = que.poll();
            topo.add(node);
            for(Integer next:adj.get(node)){
                inorder[next]--;
                if(inorder[next] == 0) que.add(next);
            }
        }
        return topo;
    }

    private int[] getInOrder(List<List<Integer>> adj, int v){
        int[] inorder = new int[v];
        for(List<Integer> edge:adj)
            for(Integer dest:edge) inorder[dest]++;
        return inorder;
    }
}
