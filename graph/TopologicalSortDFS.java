package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
* <a href="https://practice.geeksforgeeks.org/problems/topological-sort/1">Problem</a>
**/
public class TopologicalSortDFS {

    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] topoSort = new int[v];
        boolean[] visited = new boolean[v+1];
        int index = 0;
        Stack<Integer> topo = new Stack<>();
        for(int i = 0;i<v;i++)
            if(!visited[i]) dfs(i, adj, topo, visited);
        while(!topo.isEmpty()) topoSort[index++] = topo.pop();
        return topoSort;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> topo, boolean[] visited){
        visited[node] = true;
        for(Integer next:adj.get(node)){
            if(!visited[next]) dfs(next, adj, topo, visited);
        }
        topo.push(node);
    }
}
