package lcci;

/**
 * Lcci1009_1
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class Lcci1009_1 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int low = 0;
            int high = n - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = matrix[i][mid];
                if (midVal == target) {
                    return true;
                } else if (midVal > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return false;
    }

}
