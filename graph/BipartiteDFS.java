package graph;

import java.util.Arrays;
import java.util.List;

/**
* <a href="https://leetcode.com/problems/is-graph-bipartite/">Problem</a>
**/
public class BipartiteDFS {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for(int i = 0;i<graph.length;i++)
            if(colors[i] == -1 && !dfs(i, graph, colors)) return false;
        return true;
    }

    private boolean dfs(int node,int[][] graph, int[] colors){
        for(int next:graph[node]){
            if(colors[next] == -1) {
                colors[next] = 1 - colors[node];
                if(!dfs(next,graph, colors)) return false;
            }
            else if(colors[next] == colors[node]) return false;
        }
        return true;
    }
}
