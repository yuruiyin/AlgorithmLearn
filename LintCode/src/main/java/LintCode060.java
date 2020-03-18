/**
 * LintCode060
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode060 {

    public int searchInsert(int[] arr, int target) {
        // 二分
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal >= target) {
                if (mid == 0 || arr[mid - 1] < target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return arr.length;
    }

}
