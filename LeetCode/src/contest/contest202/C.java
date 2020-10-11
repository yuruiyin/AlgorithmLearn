package contest.contest202;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/16
 */
public class C {

    private boolean isOk(int[] arr, int minDis, int n, int m) {
        int count = 1;
        int pre = arr[0];
        for (int i = 1; i < n && count < m; i++) {
            if (arr[i] - pre >= minDis) {
                count++;
                pre = arr[i];
            }
        }
        return count == m;
    }

    public int maxDistance(int[] position, int m) {
        // 二分
        int n = position.length;
        Arrays.sort(position);

        int low = 1;
        int high = 1000000000;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (isOk(position, mid, n, m)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

}
