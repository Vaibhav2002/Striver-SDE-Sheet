package graph;

import java.util.ArrayList;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1#_=_">Problem</a>
 **/
public class DFS {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        var dfs = new ArrayList<Integer>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!visited[i]) dfs(i, adj, dfs, visited);
        return dfs;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, boolean[] visited) {
        dfs.add(node);
        visited[node] = true;
        for (Integer next : adj.get(node))
            if (!visited[next]) dfs(next, adj, dfs, visited);
    }
}
