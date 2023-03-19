package doubleContest.round100;

public class D {

    private boolean isOk(int[] ranks, long max, int cars) {
        long count = 0;
        for (int rank : ranks) {
            long squareN = max / rank;
            count += Math.sqrt(squareN);
            if (count >= cars) {
                return true;
            }
        }
        return false;
    }

    public long repairCars(int[] ranks, int cars) {
        long l = 1;
        long r = (long) 1e15;
        long ans = Long.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r) >>> 1L;
            if (isOk(ranks, mid, cars)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

}
