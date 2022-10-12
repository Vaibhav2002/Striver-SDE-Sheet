package graph2;

import java.util.*;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1#_=_">Problem</a>
 **/
public class PrimsMST {

    private static class Node {
        int node, weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getWeight(){
            return weight;
        }
    }

    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int[] weight = new int[v], parent = new int[v];
        boolean[] inMst = new boolean[v];
        Arrays.fill(weight, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));
        var adjList = getNodeAdj(v, adj);
        weight[0] = 0;
        pq.add(new Node(0, 0));
        while(!pq.isEmpty()) {
            var node = pq.poll();
            inMst[node.node] = true;
            for(Node next:adjList.get(node.node)){
                if(!inMst[next.node] && next.weight < weight[next.node]){
                    parent[next.node] = node.node;
                    weight[next.node] = next.weight;
                    pq.add(next);
                }
            }
        }
        int sum = 0;
        for(int i = 0;i<v;i++) sum+=weight[i];
        return sum;
    }

    private static List<List<Node>> getNodeAdj(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < v; i++) {
            for (ArrayList<Integer> dests : adj.get(i))
                adjList.get(i).add(new Node(dests.get(0), dests.get(1)));
        }
        return adjList;
    }
}
