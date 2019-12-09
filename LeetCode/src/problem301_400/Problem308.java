package problem301_400;

public class Problem308 {

    class NumMatrix {

        private int[][] matrix;
        private int[][] rowSumArr;  // 保存每个元素(i, j)在第i行的前j+1项的和。
        private int rowCount;
        private int colCount;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }

            rowCount = matrix.length;
            colCount = matrix[0].length;
            rowSumArr = new int[rowCount][colCount];
            for (int i = 0; i < rowCount; i++) {
                rowSumArr[i][0] = matrix[i][0];
                for (int j = 1; j < colCount; j++) {
                    rowSumArr[i][j] = rowSumArr[i][j-1] + matrix[i][j];
                }
            }
        }

        public void update(int row, int col, int val) {
            matrix[row][col] = val;
            int fromCol = col;
            if (col == 0) {
                rowSumArr[row][col] = matrix[row][col];
                fromCol = col + 1;
            }
            for (int j = fromCol; j < colCount; j++) {
                rowSumArr[row][j] = rowSumArr[row][j-1] + matrix[row][j];
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += col1 == 0 ? rowSumArr[i][col2] : rowSumArr[i][col2] - rowSumArr[i][col1-1];
            }
            return sum;
        }
    }

}
