package graph2;

import java.util.*;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1">Problem</a>
 **/
public class DijkstraShortestPath {

    private static class Node {
        int node, weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> a, int S) {
        int[] dist = new int[v];
        var adj = getAdjList(v, a);
        Arrays.fill(dist, Integer.MAX_VALUE);
        var pq = new PriorityQueue<Node>(Comparator.comparingInt((n) -> n.weight));
        pq.add(new Node(S, 0));
        dist[S] = 0;
        while (!pq.isEmpty()) {
            var node = pq.poll();
            for (Node next : adj.get(node.node)) {
                int len = dist[node.node] + next.weight;
                if (len < dist[next.node]) {
                    dist[next.node] = len;
                    pq.add(new Node(next.node, dist[next.node]));
                }
            }
        }
        return dist;
    }

    private static List<List<Node>> getAdjList(int v, ArrayList<ArrayList<ArrayList<Integer>>> a) {
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
            for (List<Integer> dests : a.get(i)) {
                adj.get(i).add(new Node(dests.get(0), dests.get(1)));
            }
        }
        return adj;
    }
}
