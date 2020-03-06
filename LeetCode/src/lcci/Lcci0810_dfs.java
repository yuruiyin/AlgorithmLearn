package lcci;

public class Lcci0810_dfs {

    private int[][] image;
    private int m;
    private int n;
    private int targetColor;
    private int newColor;

    private void dfs(int row, int col, boolean[][] visited) {
        if (row < 0 || row >= m || col < 0 || col >= n ||
                visited[row][col] || image[row][col] != targetColor)  {
            return;
        }

        image[row][col] = newColor;
        visited[row][col] = true;
        dfs(row + 1, col, visited);
        dfs(row - 1, col, visited);
        dfs(row, col + 1, visited);
        dfs(row, col - 1, visited);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        targetColor = image[sr][sc];
        this.newColor = newColor;
        this.image = image;
        dfs(sr, sc, new boolean[m][n]);
        return image;
    }

}
