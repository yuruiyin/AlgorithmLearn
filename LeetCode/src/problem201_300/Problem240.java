package problem201_300;

public class Problem240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j <  colCount; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }

}
