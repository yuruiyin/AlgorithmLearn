package lcci;

/**
 * Lcci1009_2
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class Lcci1009_2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            int cur = matrix[row][col];
            if (target > cur) {
                row++;
            } else if (target < cur) {
                col--;
            } else {
                return true;
            }
        }

        return false;
    }

}
