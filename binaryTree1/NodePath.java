package binaryTree1;

import java.util.ArrayList;

public class NodePath {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        var ans = new ArrayList<Integer>();
        dfs(A, B, ans);
        return ans;
    }

    private boolean dfs(TreeNode root, int target, ArrayList<Integer> path){
        if(root == null) return false;
        path.add(root.val);
        if(root.val == target) return true;
        if(dfs(root.left, target, path) || dfs(root.right, target, path))
            return true;
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        NodePath ob = new NodePath();
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(ob.solve(root, 7));
    }
}
