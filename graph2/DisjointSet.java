package graph2;

public class DisjointSet {

    private int size;
    private int[] rank, parent;

    public DisjointSet(int size) {
        this.size = size;
        rank = new int[size];
        parent = new int[size];
        initParent();
    }

    private void initParent() {
        for (int i = 0; i < parent.length; i++) parent[i] = i;
    }

    public int findParent(int n){
        if(parent[n] == n) return n;
        return parent[n] = findParent(parent[n]);
    }

    public void union(int u, int v){
        u = findParent(u);
        v = findParent(v);
        if(u == v) return;
        if(rank[u] < rank[v])
            parent[u] = v;
        else if(rank[v] < rank[u])
            parent[v] = u;
        else {
            parent[u] = v;
            rank[v]++;
        }
    }
}
