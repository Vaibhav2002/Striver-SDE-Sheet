package graph2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
* <a href="https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1">Problem</a>
**/
public class KruskalMST {
    private static class Node{
        int u, v, weight;

        public Node(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Node> nodes = getNodesList(adj);
        nodes.sort(Comparator.comparingInt((n) -> n.weight));
        DisjointSet dsu = new DisjointSet(v);
        int ans = 0;
        for(Node node:nodes){
            if(dsu.findParent(node.u) != dsu.findParent(node.v)){
                dsu.union(node.u, node.v);
                ans+=node.weight;
            }
        }
        return ans;
    }

    private static List<Node> getNodesList(ArrayList<ArrayList<ArrayList<Integer>>> adj){
        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < adj.size();i++){
            for(ArrayList<Integer> edge : adj.get(i))
                nodes.add(new Node(i, edge.get(0), edge.get(1)));
        }
        return nodes;
    }
}
