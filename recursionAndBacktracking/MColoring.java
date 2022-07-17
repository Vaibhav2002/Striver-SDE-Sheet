package recursionAndBacktracking;

import java.util.ArrayList;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#">Problem</a>
 **/
public class MColoring {

    public boolean graphColoring(boolean graph[][], int m, int n) {
        var adj = getAdjList(graph, n);
        int[] color = new int[n];
        return canColor(adj, 0, n, m, color);
    }

    private ArrayList<Integer>[] getAdjList(boolean[][] graph, int n){
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++) adj[i] = new ArrayList<>();
        for(int i=0;i<n;i++)
            for(int j = 0;j<n;j++) if(graph[i][j]) adj[i].add(j);
        return adj;
    }

    private boolean canColor(ArrayList<Integer>[] adj, int node, int n, int m, int[] color) {
        if (node == n) return true;
        for (int i = 1; i <= m; i++)
            if (isSafe(adj[node], color, i)) {
                color[node] = i;
                if(canColor(adj, node + 1, n, m, color)) return true;
                color[node] = 0;
            }
        return false;
    }

    private boolean isSafe(ArrayList<Integer> adj, int[] color, int c) {
        for (Integer edge : adj)
            if (color[edge] == c) return false;
        return true;
    }
}
