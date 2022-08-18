package binaryTree1;

import java.util.*;

/**
* <a href="https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1">Problem</a>
**/
public class TopView {

    private static class NodeWithLAndHd{
        Node node;
        int level, hd;

        public NodeWithLAndHd(Node node, int level, int hd) {
            this.node = node;
            this.level = level;
            this.hd = hd;
        }

        private NodeWithLAndHd getLeftChild(){
            return new NodeWithLAndHd(node.left, level+1, hd - 1);
        }

        private NodeWithLAndHd getRightChild(){
            return new NodeWithLAndHd(node.right, level+1, hd + 1);
        }
    }

    static ArrayList<Integer> topView(Node root)
    {
        var ans = new ArrayList<Integer>();
        if(root == null) return ans;
        bfs(root, ans);
        return ans;
    }

    private static void bfs(Node root, ArrayList<Integer> ans){
        Queue<NodeWithLAndHd> que = new LinkedList<>();
        que.add(new NodeWithLAndHd(root, 0, 0));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while(!que.isEmpty()){
            var node = que.poll();
            if(!map.containsKey(node.hd)) map.put(node.hd, node.node.data);
            if(node.node.left!=null) que.add(node.getLeftChild());
            if(node.node.right!=null) que.add(node.getRightChild());
        }
        ans.addAll(map.values());
    }

    private static void dfs(Node root, ArrayList<Integer> ans){
        var map = new TreeMap<Integer, NodeWithLAndHd>();
        dfsUtil(root, 0, 0, map);
        for(NodeWithLAndHd node:map.values()) ans.add(node.node.data);
    }

    private static void dfsUtil(Node root, int level, int hd, TreeMap<Integer, NodeWithLAndHd> map){
        if(root == null) return;
        var pre = map.get(hd);
        if(pre == null || level <= pre.level)
            map.put(hd, new NodeWithLAndHd(root, level, hd));
        dfsUtil(root.left, level+1, hd-1, map);
        dfsUtil(root.right, level+1, hd+1, map);

    }
}
