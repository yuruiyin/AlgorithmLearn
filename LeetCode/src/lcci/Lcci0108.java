package lcci;

public class Lcci0108 {

    public void setZeroes(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        boolean[] rowFlagArr = new boolean[rowCount];
        boolean[] colFlagArr = new boolean[colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (matrix[i][j] == 0) {
                    rowFlagArr[i] = true;
                    colFlagArr[j] = true;
                }
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (rowFlagArr[i] || colFlagArr[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
