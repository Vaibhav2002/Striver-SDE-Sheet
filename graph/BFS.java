package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1">Problem</a>
 **/
public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) fillBfs(i, adj, bfs, visited);
        }
        return bfs;
    }

    private void fillBfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> bfs, boolean[] visited) {
        Queue<Integer> que = new LinkedList<>();
        que.add(node);
        while (!que.isEmpty()) {
            var cur = que.poll();
            bfs.add(cur);
            for (Integer next : adj.get(cur)) {
                if (!visited[next]) {
                    que.add(next);
                    visited[next] = true;
                }
            }
        }

    }
}
