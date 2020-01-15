package problem1301_1400;

public class Problem1314_2 {

    private int[][] preMatSumArr;
    private int rowCount;
    private int colCount;

    // 矩阵前缀和
    private void calcMatPreSum(int[][] mat) {
        preMatSumArr = new int[rowCount+1][colCount+1];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                preMatSumArr[i+1][j+1] = preMatSumArr[i][j+1] + preMatSumArr[i+1][j] - preMatSumArr[i][j] + mat[i][j];
            }
        }
    }

    private int getMatSum(int minRow, int minCol, int maxRow, int maxCol) {
        return preMatSumArr[maxRow + 1][maxCol + 1] -
                preMatSumArr[minRow][maxCol + 1] -
                preMatSumArr[maxRow + 1][minCol] +
                preMatSumArr[minRow][minCol];
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
        rowCount = mat.length;
        colCount = mat[0].length;
        int[][] ans = new int[rowCount][colCount];
        calcMatPreSum(mat);

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int minRow = Math.max(0, i - k);
                int minCol =  Math.max(0, j - k);
                int maxRow = Math.min(i + k, rowCount - 1);
                int maxCol = Math.min(j + k, colCount - 1);
                ans[i][j] += getMatSum(minRow, minCol, maxRow, maxCol);
            }
        }

        return ans;
    }

}
