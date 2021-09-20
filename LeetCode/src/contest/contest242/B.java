package contest.contest242;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/23
 */
public class B {

    private boolean isOk(int[] arr, double hour, double speed) {
        double ans = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            double t = arr[i] / speed;
            if (i == len - 1) {
                ans += t;
            } else {
                if (arr[i] % speed == 0) {
                    ans += t;
                } else {
                    ans += Math.ceil(arr[i] / speed);
                }
            }
        }

        return ans <= hour;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1;
        int r = Integer.MAX_VALUE - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOk(dist, hour, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

}
