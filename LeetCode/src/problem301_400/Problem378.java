package problem301_400;

public class Problem378 {

    public int kthSmallest(int[][] matrix, int k) {
        // 二分
        int row = matrix.length;
        int col = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[row - 1][col - 1];

        while (low < high) {
            int mid = (low + high) >> 1;
            int count = getNotBiggerCount(matrix, mid);

            if (count >= k) {
                // 第k小元素在左半部分，可能包含mid
                high = mid;
            } else {
                // 第k小元素在右半部分，不包含mid
                low = mid + 1;
            }
        }

        return high;
    }

    private int findLastNotBiggerRowIndex(int[][] matrix, int target) {
        int row = matrix.length;
        // 先二分查找每行的第一个元素最后一个不比target大的元素
        int low = 0;
        int high = row - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (target >= matrix[mid][0]) {
                if (mid == row - 1 || target < matrix[mid + 1][0]) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int findLastNotBiggerColIndex(int[][] matrix, int curRow, int target) {
        int col = matrix[0].length;
        // 先二分查找每行的第一个元素最后一个不比target大的元素
        int low = 0;
        int high = col - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (target >= matrix[curRow][mid]) {
                if (mid == col - 1 || target < matrix[curRow][mid + 1]) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int getNotBiggerCount(int[][] matrix, int target) {
        int count = 0;

        // 先二分查找每行的第一个元素最后一个不比target大的元素
        int lastNotBiggerRowIndex = findLastNotBiggerRowIndex(matrix, target);

        if (lastNotBiggerRowIndex == -1) {
            return 0;
        }

        for (int i = lastNotBiggerRowIndex; i >= 0; i--) {
            // 继续二分查找当前行，最后一个<=target的元素位置
            int lastNotBiggerColIndex = findLastNotBiggerColIndex(matrix, i, target);
            count += (lastNotBiggerColIndex + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Problem378().kthSmallest(new int[][]{
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        }, 8));
    }

}
