package lcof;

// 同LC_240
public class Lcof004 {

    private int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal == target) {
                return mid;
            } else if (target < midVal) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 二分
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // 逐行二分遍历
        for (int[] rowArr: matrix) {
            int res = binarySearch(rowArr, target);
            if (res != -1) {
                return true;
            }

            if (target < rowArr[0]) {
                // target比当前行的第一个元素还小，后面的元素都比rowArr[0]大，因此没必要再找了
                return false;
            }
        }

        return false;
    }

}
