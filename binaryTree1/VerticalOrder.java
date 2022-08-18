package binaryTree1;

import com.sun.source.tree.Tree;

import java.util.*;

/**
* <a href="https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/">Problem</a>
**/
public class VerticalOrder {

    private static class NodeWithHd implements Comparable<NodeWithHd>{
        TreeNode node;
        int hd, level;

        public NodeWithHd(TreeNode node, int hd, int level) {
            this.node = node;
            this.hd = hd;
            this.level = level;
        }

        public NodeWithHd getLeftChild(){
            return new NodeWithHd(node.left, hd-1, level+1);
        }

        public NodeWithHd getRightChild(){
            return new NodeWithHd(node.right, hd+1, level+1);
        }

        @Override
        public int compareTo(NodeWithHd o) {
            return Integer.compare(node.val, o.node.val);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        bfs(root, ans);
        return ans;
    }

    private void bfs(TreeNode root, List<List<Integer>> ans){
        var map = new TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>();
        Queue<NodeWithHd> que = new LinkedList<>();
        que.add(new NodeWithHd(root, 0, 0));
        while(!que.isEmpty()){
            var node = que.poll();
            map.putIfAbsent(node.hd, new TreeMap<>());
            map.get(node.hd).putIfAbsent(node.level, new PriorityQueue<>());
            map.get(node.hd).get(node.level).add(node.node.val);
            if(node.node.left!=null) que.add(node.getLeftChild());
            if(node.node.right!=null) que.add(node.getRightChild());
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> tree:map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> vals:tree.values()){
                while(!vals.isEmpty()) ans.get(ans.size() - 1).add(vals.poll());
            }
        }
    }
}
