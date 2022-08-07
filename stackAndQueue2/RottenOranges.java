package stackAndQueue2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/rotting-oranges/">Problem</a>
 **/
public class RottenOranges {

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isInBounds(int r, int c) {
            return x >= 0 && x < r && y >= 0 && y < c;
        }
    }

    private final int[] dirX = {-1, 0, 0, 1};
    private final int[] dirY = {0, -1, 1, 0};

    public int orangesRotting(int[][] grid) {
        int time = -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Point> que = new LinkedList<>(getInitialOranges(grid, visited));
        int countFresh = countOranges(grid), count = 0;
        if(countFresh == 0) return 0;
        while(!que.isEmpty()){
            int len = que.size();
            count+=len;
            time++;
            for(int i=0;i<len;i++){
                var point = que.poll();
                que.addAll(getNeighbouringPoints(point, grid, visited));
            }
        }
        return count == countFresh?time:-1;
    }

    private List<Point> getNeighbouringPoints(Point p, int[][] grid, boolean[][] visited) {
        List<Point> neighbours = new ArrayList<>();
        for(int i=0;i<4;i++){
            int newX = p.x+dirX[i], newY = p.y+dirY[i];
            var newPoint = new Point(newX, newY);
            if(isValid(newPoint, grid, visited)){
                neighbours.add(newPoint);
                visited[newX][newY] = true;
            }
        }
        return neighbours;
    }

    private boolean isValid(Point p, int[][] grid, boolean[][] visited) {
        return p.isInBounds(grid.length, grid[0].length) && !visited[p.x][p.y] && grid[p.x][p.y] == 1;
    }

    private List<Point> getInitialOranges(int[][] grid, boolean[][] visited){
        List<Point> initial = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    initial.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }
        return initial;
    }

    private int countOranges(int[][] grid){
        int count = 0;
        for(int[] i:grid)
            for(int j:i)
                if(j != 0) count++;
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println(new RottenOranges().orangesRotting(grid));
    }

}
