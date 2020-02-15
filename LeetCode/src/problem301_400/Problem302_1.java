package problem301_400;

import java.util.LinkedList;

public class Problem302_1 {

    private int minRow;
    private int maxRow;
    private int minCol;
    private int maxCol;
    private int m;
    private int n;
    private char[][] image;

    private void dfs(int row, int col, boolean[][] visited) {
        if (row < 0 || row >= m || col < 0|| col >= n ||
                image[row][col] == '0' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        minRow = Math.min(minRow, row);
        maxRow = Math.max(maxRow, row);
        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);

        dfs(row - 1, col , visited);
        dfs(row + 1, col , visited);
        dfs(row, col - 1 , visited);
        dfs(row, col + 1 , visited);
    }

    public int minArea(char[][] image, int x, int y) {
        m = image.length;
        n = image[0].length;
        this.image = image;
        minRow = x;
        maxRow = x;
        minCol = y;
        maxCol = y;
        dfs(x, y, new boolean[m][n]);
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }


}
