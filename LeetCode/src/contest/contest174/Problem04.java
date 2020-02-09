package contest.contest174;

public class Problem04 {

    private int[] arr;
    private int len;
    private int d;
    private Integer[] memo;

    private int dp(int idx) {
        if (memo[idx] != null) {
            return memo[idx];
        }

        int max = 0;
        for (int x = 1; x <= d && idx + x < len && arr[idx] > arr[idx + x]; x++) {
            int res = dp(idx + x);
            max = Math.max(max, res);
        }

        int max1 = 0;
        for (int x = 1; x <= d && idx - x >= 0 && arr[idx] > arr[idx - x]; x++) {
            int res = dp(idx - x);
            max1 = Math.max(max1, res);
        }

        memo[idx] = Math.max(max, max1) + 1;
        return memo[idx];
    }

    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.len = arr.length;
        this.d = d;

        memo = new Integer[len];
        for (int i = 0; i < len; i++) {
            dp(i);
        }

        int ansMax = Integer.MIN_VALUE;
        for(Integer num : memo) {
            ansMax = Math.max(ansMax, num);
        }

        return ansMax;
    }

}
