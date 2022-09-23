package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/is-graph-bipartite/">Problem</a>
 **/
public class BipartiteBFS {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1 && !bfs(i, graph, colors)) return false;
        }
        return true;
    }

    private boolean bfs(int start, int[][] graph, int[] colors) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        while (!que.isEmpty()) {
            var node = que.poll();
            for (Integer next : graph[node]) {
                if (colors[next] == -1) {
                    colors[next] = 1 - colors[node];
                    que.add(next);
                } else if (colors[next] == colors[node]) return false;
            }
        }
        return true;
    }
}
