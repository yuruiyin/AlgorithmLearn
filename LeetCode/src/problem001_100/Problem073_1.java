package problem001_100;

public class Problem073_1 {

    /**
     * 使用映射到首行首列的方式
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int j = 0; j < colNum; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < rowNum; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
        }

        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j < colNum; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int j = 1; j < colNum; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rowNum; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < rowNum; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < colNum; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int j = 0; j < colNum; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < rowNum; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    
    public static void main(String[] args) {

    }
    
}
