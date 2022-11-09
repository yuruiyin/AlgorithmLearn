package contest.contest102;

public class Problem907 {

    private static final int MOD = (int) (1e9 + 7);

    public int sumSubarrayMins(int[] arr) {
        // 计算右侧第一个比当前数小的数
        int len = arr.length;
        int[] stack = new int[len];
        stack[0] = len - 1;
        int stackSize = 1;
        long ans = arr[len - 1];
        long[] dp = new long[len];
        dp[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            while (stackSize > 0 && arr[i] <= arr[stack[stackSize - 1]]) {
                stackSize--;
            }
            if (stackSize > 0) {
                dp[i] = (long) (stack[stackSize - 1] - i) * arr[i] + dp[stack[stackSize - 1]];
            } else {
                dp[i] = (long) (len - i) * arr[i];
            }
            ans += dp[i];
            stack[stackSize++] = i;
        }
        return (int) (ans % MOD);
    }

}
