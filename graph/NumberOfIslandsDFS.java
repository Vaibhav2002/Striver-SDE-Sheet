package graph;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/">Problem</a>
 **/
public class NumberOfIslandsDFS {

    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid, visited);
                    count++;
                }
        return count;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if (!isValid(i, j, grid, visited)) return;
        visited[i][j] = true;
        dfs(i - 1, j, grid, visited); //top
        dfs(i, j + 1, grid, visited); //right
        dfs(i + 1, j, grid, visited); //bottom
        dfs(i, j - 1, grid, visited); //left
    }

    private boolean isValid(int i, int j, char[][] grid, boolean[][] visited) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && !visited[i][j] && grid[i][j] != '0';
    }
}
