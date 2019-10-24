package interview_google.round03;

public class Problem02 {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rowCnt = grid.length;
        int colCnt = grid[0].length;

        int[][] sum = new int[rowCnt][colCnt];
        sum[0][0] = grid[0][0];

        // 第一行
        for (int j = 1; j < colCnt; j++) {
            sum[0][j] = sum[0][j-1] + grid[0][j];
        }

        // 第一列
        for (int i = 1; i < rowCnt; i++) {
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < rowCnt; i++) {
            for (int j = 1; j < colCnt; j++) {
                sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
            }
        }

        return sum[rowCnt - 1][colCnt - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem02().minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }
    
}
