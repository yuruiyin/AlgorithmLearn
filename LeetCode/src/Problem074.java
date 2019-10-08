public class Problem074 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }

        int n = matrix[0].length;

        if (n == 0) {
            return false;
        }

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int i = mid / n;
            int j = mid % n;
            int midValue = matrix[i][j];
            if (target == midValue) {
                return true;
            } else if (target < midValue) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(new Problem074().searchMatrix(matrix, 3));

        int[][] matrix1 = new int[][]{
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(new Problem074().searchMatrix(matrix1, 13));
    }

}
