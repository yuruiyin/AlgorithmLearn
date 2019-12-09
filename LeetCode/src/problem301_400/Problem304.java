package problem301_400;

public class Problem304 {

    class NumMatrix {

        private int[][] matrix;
        private int[][] rowBeforeSumMatrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            init();
        }

        private void init() {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }

            int rowNum = matrix.length;
            int colNum = matrix[0].length;
            rowBeforeSumMatrix = new int[rowNum][colNum];
            for (int i = 0; i < rowNum; i++) {
                rowBeforeSumMatrix[i][0] = matrix[i][0];
            }

            for (int i = 0; i < rowNum; i++) {
                for (int j = 1; j < colNum; j++) {
                    rowBeforeSumMatrix[i][j] = matrix[i][j] + rowBeforeSumMatrix[i][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += col1 == 0 ? rowBeforeSumMatrix[i][col2] : rowBeforeSumMatrix[i][col2] - rowBeforeSumMatrix[i][col1 - 1];
            }

            return sum;
        }
    }

}
