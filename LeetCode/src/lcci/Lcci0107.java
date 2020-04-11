package lcci;

public class Lcci0107 {

    public void rotate(int[][] grid) {
        for (int s = 0, e = grid.length - 1; s < e; s++, e--) {
            for (int j = s; j < e; j++) {
                int tmp = grid[s][j];
                grid[s][j] = grid[e - (j - s)][s];
                grid[e - (j - s)][s] = grid[e][e - (j - s)];
                grid[e][e - (j - s)] = grid[j][e];
                grid[j][e] = tmp;
            }
        }
    }
}
