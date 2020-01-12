package doubleContest.round17;

public class Problem02_1 {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rowCount = mat.length;
        int colCount = mat[0].length;

        int[][] ans = new int[rowCount][colCount];
        int[][] preSumArr = new int[rowCount][colCount+1];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                preSumArr[i][j+1] = preSumArr[i][j] + mat[i][j];
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                for (int r = Math.max(0, i - k); r <= Math.min(i + k, rowCount - 1); r++) {
                    int maxJ = Math.min(j + k, colCount - 1);
                    int minJ = Math.max(0, j - k);
                    ans[i][j] += preSumArr[r][maxJ+1] - preSumArr[r][minJ];
                }
            }
        }

        return ans;
    }

}
