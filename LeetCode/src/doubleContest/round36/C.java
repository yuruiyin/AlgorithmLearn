package doubleContest.round36;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/3
 */
public class C {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rowCount = rowSum.length;
        int colCount = colSum.length;

        int[][] grid = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            int sum = 0;
            for (int j = 0; j < colCount; j++) {
                if (sum + colSum[j] >= rowSum[i]) {
                    grid[i][j] = rowSum[i] - sum;
                    colSum[j] -= (rowSum[i] - sum);
                    break;
                } else {
                    grid[i][j] = colSum[j];
                    sum += colSum[j];
                    colSum[j] = 0;
                }
            }
        }

        return grid;
    }

}
