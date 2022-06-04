package contest.contest282;

import java.util.Arrays;

public class C {

    private boolean isOk(int[] times, int totalTrips, long target) {
        long count = 0;
        for (int time : times) {
            count += target / time;
            if (count >= totalTrips) {
                return true;
            }
        }
        return false;
    }

    public long minimumTime(int[] time, int totalTrips) {
        // 二分
        long l = 1;
        long r = (long) 1e14;
        Arrays.sort(time);
        long ans = Long.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r) >>> 1L;
            if (isOk(time, totalTrips, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new C().minimumTime(new int[]{10000000}, 10000000));
    }

}
