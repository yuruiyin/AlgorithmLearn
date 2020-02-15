package lcof;

public class Lcof029 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int minCol = 0;
        int maxCol = n-1;
        int minRow = 0;
        int maxRow = m - 1;

        int direction = 0;
        int[] ansArr = new int[m * n];
        int count = 0;
        while (count < m * n) {
            if (direction == 0) {
                for (int j = minCol; j <= maxCol; j++) {
                    ansArr[count++] = matrix[minRow][j];
                }
                minRow++;
            } else if (direction == 1) {
                for (int i = minRow; i <= maxRow; i++) {
                    ansArr[count++] = matrix[i][maxCol];
                }
                maxCol--;
            } else if (direction == 2) {
                for (int j = maxCol; j >= minCol; j--) {
                    ansArr[count++] = matrix[maxRow][j];
                }
                maxRow--;
            } else {
                for (int i = maxRow; i >= minRow; i--) {
                    ansArr[count++] = matrix[i][minCol];
                }
                minCol++;
            }

            direction = (direction + 1) % 4;

        }

        return ansArr;
    }

}
