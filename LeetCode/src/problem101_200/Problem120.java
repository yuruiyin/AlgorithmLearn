package problem101_200;

import java.util.List;

public class Problem120 {

    private List<List<Integer>> triangle;
    private int rowCount;
    private int colCount; // 最后一行的元素个数
    private int[][] memo;

    /**
     * 自顶向下 递归
     */
    private int dfs(int row, int col) {
        if (row == rowCount) {
            return 0;
        }

        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        memo[row][col] = Math.min(dfs(row + 1, col), dfs(row + 1, col + 1)) + triangle.get(row).get(col);

        return memo[row][col];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        this.rowCount = triangle.size();
        this.colCount = triangle.get(rowCount - 1).size();
        memo = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(0, 0);
    }
    
    public static void main(String[] args) {

    }
    
}
