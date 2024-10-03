package contest.contest416;

public class B {

    private boolean isOk(int mountainHeight, int[] workerTimes, long maxTime) {
        int h = mountainHeight;
        for (long time : workerTimes) {
            int l = 0;
            int r = h;
            int x = 0;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (mid * (mid + 1L) * time <= 2 * maxTime) {
                    l = mid + 1;
                    x = mid;
                } else {
                    r = mid - 1;
                }
            }

            mountainHeight -= x;
            if (mountainHeight <= 0) {
                return true;
            }
        }
        return false;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l = 1;
        long r = (long) 1e16;
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) >>> 1;
            if (isOk(mountainHeight, workerTimes, mid)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new B().minNumberOfSeconds(9, new int[]{1, 8}));
//        System.out.println(new B().minNumberOfSeconds(4, new int[]{2, 1, 1}));
    }

}
