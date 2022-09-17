package binaryTreeMiscellaneous;

public class FloodFillDFS {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        color(sr, sc, image[sr][sc], color, image);
        return image;
    }

    private void color(int x, int y, int color, int newColor, int[][] image) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != color || image[x][y] == newColor) return;
        image[x][y] = newColor;
        color(x-1, y, color, newColor, image);
        color(x+1, y, color, newColor, image);
        color(x, y-1, color, newColor, image);
        color(x, y+1, color, newColor, image);
    }
}
