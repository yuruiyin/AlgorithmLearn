package interview_bytedance.round11;

public class Problem02 {

    private final static int BE_ZERO_VALUE = Integer.MIN_VALUE + 1;

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rowNum = matrix.length;
        int colNum = matrix[0].length;



        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < colNum; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = BE_ZERO_VALUE;
                        }
                    }

                    for (int x = 0; x < rowNum; x++) {
                        if (matrix[x][j] != 0) {
                            matrix[x][j] = BE_ZERO_VALUE;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (matrix[i][j] == BE_ZERO_VALUE) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
    
    public static void main(String[] args) {
        
    }
    
}
