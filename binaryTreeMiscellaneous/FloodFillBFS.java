package binaryTreeMiscellaneous;

import java.util.*;

public class FloodFillBFS {

    private static class Pixel {
        int x, y, color;

        Pixel(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pixel(int x, int y, int color) {
            this(x, y);
            this.color = color;
        }


        ArrayList<Pixel> getNearby() {
            var nearby = new ArrayList<Pixel>();
            int[] dirX = {-1, 0, 0, 1};
            int[] dirY = {0, -1, 1, 0};
            for (int i = 0; i < 4; i++)
                nearby.add(new Pixel(x + dirX[i], y + dirY[i]));
            return nearby;
        }

        Pixel setColor(int color){
            this.color = color;
            return this;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        Queue<Pixel> que = new LinkedList<>();
        boolean[][] visited = new boolean[image.length][image[0].length];
        que.add(new Pixel(sr, sc, image[sr][sc]));
        while (!que.isEmpty()) {
            var p = que.poll();
            var nearby = getNearby(p, image, visited);
            image[p.x][p.y] = color;
            que.addAll(nearby);
        }
        return image;
    }

    private List<Pixel> getNearby(Pixel pixel, int[][] image, boolean[][] visited) {
        var nearby = pixel.getNearby().stream()
                .filter((p) -> isValidPixel(p, image.length, image[0].length, visited))
                .map((p)->p.setColor(image[p.x][p.y]))
                .filter((p) -> pixel.color == p.color)
                .toList();
        for (Pixel p : nearby) visited[p.x][p.y] = true;
        return nearby;
    }

    private boolean isValidPixel(Pixel p, int r, int c, boolean[][] visited) {
        return p.x >= 0 && p.y >= 0 && p.x < r && p.y < c && !visited[p.x][p.y];
    }
}
