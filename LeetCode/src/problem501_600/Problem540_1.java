package problem501_600;

public class Problem540_1 {

    /**
     * 二分解法
     */
    public int singleNonDuplicate(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return arr[0];
        }
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (mid == 0) {
                if (arr[mid] != arr[mid + 1]) {
                    return arr[mid];
                }
                l = mid + 1;
            } else if (mid == len - 1) {
                if (arr[mid] != arr[mid - 1]) {
                    return arr[mid];
                }
                r = mid - 1;
            } else if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            } else {
                if ((mid + 1) % 2 == (arr[mid] == arr[mid - 1] ? 0 : 1)) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

}
