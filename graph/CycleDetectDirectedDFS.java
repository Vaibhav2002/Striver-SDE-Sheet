package graph;

import java.util.List;

public class CycleDetectDirectedDFS implements CycleDetect {

    @Override
    public boolean isCyclePresent(List<List<Integer>> adj, int v) {
        return checkUsingDFS(adj, v);
    }

    private boolean checkUsingDFS(List<List<Integer>> adj, int v) {
        boolean[] visited = new boolean[v + 1], dfsVisited = new boolean[v + 1];
        for (int i = 0; i < v; i++) {
            if (!visited[i] && cycleCheck(i, adj, visited, dfsVisited)) return true;
        }
        return false;
    }

    private boolean cycleCheck(int node, List<List<Integer>> adj, boolean[] visited, boolean[] dfsVisited) {
        visited[node] = true;
        dfsVisited[node] = true;
        for (Integer next : adj.get(node)) {
            if (!visited[next])
                if (cycleCheck(next, adj, visited, dfsVisited)) return true;
            if (dfsVisited[next]) return true;
        }
        dfsVisited[node] = false;
        return false;
    }
}
