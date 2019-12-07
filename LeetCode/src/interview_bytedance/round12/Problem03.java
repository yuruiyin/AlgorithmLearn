package interview_bytedance.round12;

public class Problem03 {

    private int len;
    private int[] sumArr;
    private int[][] memo;

    private int backTrack(int from, int m) {
        if (from == len) {
            return m == 0 ? 0 : -1;
        }

        if (m <= 0 || len - from < m) {
            return -1;
        }

        if (memo[from][m] != -2) {
            return memo[from][m];
        }

        int maxMin = Integer.MAX_VALUE;
        for (int i = from; i < len; i++) {
            int curSum = from == 0 ? sumArr[i] : sumArr[i] - sumArr[from-1];
            int nextMaxMin = backTrack(i + 1, m-1);
            if (nextMaxMin == -1) {
                continue;
            }
            int tmpMax = Math.max(curSum, nextMaxMin);
            maxMin = Math.min(tmpMax, maxMin);
        }

        memo[from][m] = maxMin;
        return maxMin;
    }

    public int splitArray(int[] nums, int m) {
        len = nums.length;
        sumArr = new int[len];
        sumArr[0] = nums[0];

        for (int i = 1; i < len; i++) {
            sumArr[i] = sumArr[i-1] + nums[i];
        }

        memo = new int[len][m+1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < m+1; j++) {
                memo[i][j] = -2;
            }
        }
        return backTrack(0, m);
    }

}
