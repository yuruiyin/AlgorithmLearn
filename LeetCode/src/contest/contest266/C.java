package contest.contest266;

/**
 * C
 *
 * @author: yry
 * @date: 2021/11/7
 */
public class C {

    private boolean isOk(int[] arr, int len, int max, int n) {
        int cur = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] > 0 && cur >= n + 1) {
                return false;
            }

            cur += (arr[i] / max) + (arr[i] % max == 0 ? 0 : 1);
        }
        return cur <= n;
    }

    public int minimizedMaximum(int n, int[] arr) {
        int len = arr.length;
        int l = 1;
        int r = 100000;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOk(arr, len, mid, n)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

}
