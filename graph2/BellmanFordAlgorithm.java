package graph2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* <a href="https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/0?fbclid=IwAR2_lL0T84DnciLyzMTQuVTMBOi82nTWNLuXjUgahnrtBgkphKiYk6xcyJU">Problem</a>
**/
public class BellmanFordAlgorithm {

    private static class Node{
        int u, v, weight;

        public Node(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static int[] bellman_ford(int v, ArrayList<ArrayList<Integer>> edges, int s) {
        int[] cost = new int[v];
        Arrays.fill(cost, Integer.MAX_VALUE);
        var adj = getAdjList(v, edges);
        cost[s] = 0;
        for(int i = 0;i<v - 1;i++){
            for(Node node:adj){
                int curCost = cost[node.u]+node.weight;
                if(curCost < cost[node.v]) cost[node.v] = curCost;
            }
        }
        for(Node node:adj){
            int curCost = cost[node.u]+node.weight;
            if(curCost < cost[node.v]) return new int[]{-1};
        }
        return cost;
    }

    private static List<Node> getAdjList(int v, ArrayList<ArrayList<Integer>> edges){
        List<Node> adj = new ArrayList<>();
        for(ArrayList<Integer> edge:edges)
            adj.add(new Node(edge.get(0), edge.get(1), edge.get(2)));
        return adj;
    }
}
