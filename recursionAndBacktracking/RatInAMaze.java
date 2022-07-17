package recursionAndBacktracking;

import java.util.ArrayList;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1">Problem</a>
 **/
public class RatInAMaze {


    public static ArrayList<String> findPath(int[][] m, int n) {
        var ans = new ArrayList<String>();
        boolean[][] visited = new boolean[n + 1][n + 1];
        fill(m, 0, 0, visited, new StringBuilder(), ans);
        return ans;
    }

    private static void fill(int[][] m, int i, int j, boolean[][] visited, StringBuilder sb, ArrayList<String> ans) {
        if (i < 0 || j < 0 || i >= m.length || j >= m[0].length || m[i][j] == 0 || visited[i][j]) return;
        if (i == m.length - 1 && j == m[0].length - 1) {
            ans.add(sb.toString());
            return;
        }
        visited[i][j] = true;

        //up
        sb.append("U");
        fill(m, i - 1, j, visited, sb, ans);
        sb.deleteCharAt(sb.length() - 1);

        //down
        sb.append("D");
        fill(m, i + 1, j, visited, sb, ans);
        sb.deleteCharAt(sb.length() - 1);

        //left
        sb.append("L");
        fill(m, i, j - 1, visited, sb, ans);
        sb.deleteCharAt(sb.length() - 1);

        //right
        sb.append("R");
        fill(m, i, j + 1, visited, sb, ans);
        sb.deleteCharAt(sb.length() - 1);

        visited[i][j] = false;
    }
}
