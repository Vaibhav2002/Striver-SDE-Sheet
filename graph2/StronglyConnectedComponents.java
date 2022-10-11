package graph2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponents {

    public List<List<Integer>> getSCC(List<List<Integer>> adj, int v){
        var topo = topoSort(adj, v);
        var transpose = getTranspose(adj, v);
        boolean[] visited = new boolean[v];
        List<List<Integer>> scc = new ArrayList<>();
        while(!topo.isEmpty()){
            int node = topo.pop();
            if(visited[node]) continue;
            List<Integer> dfs = new ArrayList<>();
            dfs(node, transpose, dfs, visited);
            scc.add(dfs);
        }
        return scc;
    }

    private void dfs(int node, List<List<Integer>> adj, List<Integer> dfs, boolean[] visited){
        visited[node] = true;
        dfs.add(node);
        for(Integer next:adj.get(node))
            if(!visited[next]) dfs(next, adj, dfs, visited);
    }

    private List<List<Integer>> getTranspose(List<List<Integer>> adj, int v){
        List<List<Integer>> trans = new ArrayList<>();
        for(int i = 0;i<v;i++) trans.add(new ArrayList<>());
        for(int i = 0;i<v;i++)
            for(Integer next:adj.get(i)) trans.get(next).add(i);
        return trans;
    }

    private Stack<Integer> topoSort(List<List<Integer>> adj, int v){
        boolean[] visited = new boolean[v];
        Stack<Integer> topo = new Stack<>();
        for(int i = 0;i<v;i++) if(!visited[i]) topoDFS(i, adj, topo, visited);
        return topo;
    }

    private void topoDFS(int node, List<List<Integer>> adj, Stack<Integer> topo, boolean[] visited){
        visited[node] = true;
        for(Integer next:adj.get(node))
            if(!visited[next]) topoDFS(next, adj, topo, visited);
        topo.push(node);
    }

    public static void main(String[] args) {
        StronglyConnectedComponents ob = new StronglyConnectedComponents();
        int v = 7;
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>()); // for Node 0
        adj.add(new ArrayList<>(List.of(3))); // for Node 1
        adj.add(new ArrayList<>(List.of(1))); // for Node 2
        adj.add(new ArrayList<>(List.of(2, 5))); // for Node 3
        adj.add(new ArrayList<>(List.of(6))); // for Node 4
        adj.add(new ArrayList<>(List.of(4))); // for Node 5
        adj.add(new ArrayList<>(List.of(5))); // for Node 6

        System.out.println(ob.getSCC(adj, v).toString());
    }
}
