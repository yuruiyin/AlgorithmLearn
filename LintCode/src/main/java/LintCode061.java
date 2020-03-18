/**
 * LintCode061
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode061 {

    private int findFirstIndex(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal == target) {
                if (mid == 0 || arr[mid - 1] != target) {
                    return mid;
                }
                high = mid - 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int findLastIndex(int[] arr, int target) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal == target) {
                if (mid == len - 1 || arr[mid + 1] != target) {
                    return mid;
                }
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] arr, int target) {
        // write your code here
        return new int[]{findFirstIndex(arr, target), findLastIndex(arr, target)};
    }

}
