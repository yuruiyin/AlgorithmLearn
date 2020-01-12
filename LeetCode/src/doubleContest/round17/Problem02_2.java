package doubleContest.round17;

public class Problem02_2 {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rowCount = mat.length;
        int colCount = mat[0].length;

        int[][] ans = new int[rowCount][colCount];
        int[][] preMatSumArr = new int[rowCount+1][colCount+1];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                preMatSumArr[i+1][j+1] = preMatSumArr[i][j+1] + preMatSumArr[i+1][j] - preMatSumArr[i][j] + mat[i][j];
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int minI = Math.max(0, i - k);
                int minJ =  Math.max(0, j - k);
                int maxI = Math.min(i + k, rowCount - 1) + 1;
                int maxJ = Math.min(j + k, colCount - 1) + 1;
                ans[i][j] += preMatSumArr[maxI][maxJ] - preMatSumArr[minI][maxJ] - preMatSumArr[maxI][minJ] +
                        preMatSumArr[minI][minJ];
            }
        }

        return ans;
    }

}
