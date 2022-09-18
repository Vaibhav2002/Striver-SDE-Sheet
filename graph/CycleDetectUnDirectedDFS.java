package graph;

import java.util.List;

public class CycleDetectUnDirectedDFS implements CycleDetect {
    @Override
    public boolean isCyclePresent(List<List<Integer>> adj, int v) {
        return checkUsingDFS(adj, v);
    }

    private boolean checkUsingDFS(List<List<Integer>> adj, int v) {
        boolean[] visited = new boolean[v + 1];
        for (int i = 0; i < v; i++) {
            if (!visited[i] && dfsUtil(i, -1, adj, visited)) return true;
        }
        return false;
    }

    private boolean dfsUtil(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (Integer next : adj.get(node)) {
            if (!visited[next] && dfsUtil(next, node, adj, visited)) return true;
            else if (next != parent) return true;
        }
        return false;
    }
}
