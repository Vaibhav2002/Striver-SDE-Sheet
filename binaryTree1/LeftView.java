package binaryTree1;

import java.lang.reflect.Array;
import java.util.*;

/**
* <a href="https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1#_=_">Problem</a>
**/
public class LeftView {
    ArrayList<Integer> leftView(Node root)
    {
        var ans = new ArrayList<Integer>();
        if(root == null) return ans;
        bfs(root, ans);
        return ans;
    }

    private void bfs(Node root, ArrayList<Integer> ans){
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int len = que.size();
            for(int i = 0;i<len;i++){
                var node = que.poll();
                if(i == 0) ans.add(node.data);
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
        }
    }

    private void dfs(Node root, ArrayList<Integer> ans){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        dfsUtil(root, 0, map);
        for(Integer level:map.keySet()) ans.add(map.get(level));
    }

    private void dfsUtil(Node root, int level, TreeMap<Integer, Integer> map){
        if(root == null) return;
        if(!map.containsKey(level)) map.put(level, root.data);
        dfsUtil(root.left, level+1, map);
        dfsUtil(root.right, level+1, map);
    }
}
