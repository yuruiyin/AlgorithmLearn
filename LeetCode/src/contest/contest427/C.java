package contest.contest427;

public class C {

    public long maxSubarraySum(int[] nums, int k) {
        int len = nums.length;
        long[] preSumArr = new long[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }

        long ansMax = Long.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            long pre = 0;
            for (int j = i + k - 1; j < len; j += k) {
                long cur = preSumArr[j] - (j - k < 0 ? 0 : preSumArr[j - k]);
                if (pre <= 0) {
                    pre = cur;
                } else {
                    pre += cur;
                }
                ansMax = Math.max(ansMax, pre);
            }
        }
        return ansMax;
    }

}
