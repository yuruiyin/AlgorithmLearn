package problem1201_1300;

/**
 * Problem1231
 *
 * @author: yry
 * @date: 2020/3/27
 */
public class Problem1231 {

    private boolean isOk(int[] arr, int k, int lower) {
        // 划分成k组，每组的和都必须大于lower
        int sum = 0;
        int count = 0;
        for (int num : arr) {
            sum += num;
            if (sum >= lower) {
                count++;
                if (count == k) {
                    return true;
                }
                sum = 0;
            }
        }
        return count >= k;
    }

    public int maximizeSweetness(int[] arr, int k) {
        // 二分猜答案
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            sum += num;
            min = Math.min(min, num);
        }

        int low = min;
        int high = sum / (k + 1);
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (isOk(arr, k + 1, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

}
