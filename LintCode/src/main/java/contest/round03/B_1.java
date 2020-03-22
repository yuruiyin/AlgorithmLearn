package contest.round03;

/**
 * B_1
 *
 * @author: yry
 * @date: 2020/3/21
 */
public class B_1 {

    private static final int MOD = 1000000007;

    public int ratJump(int[] arr) {
        // Write your code here.
        int len = arr.length;
        long[][] dp = new long[len + 3][2];
        dp[0][0] = 1;
        dp[0][1] = 0;

        for (int i = 1; i < len + 3; i++) {
            if (i < len && arr[i] == 1) {
                dp[i][0] = 0;
                dp[i][1] = 0;
                continue;
            }

            if (i - 1 < len - 1) dp[i][0] = (dp[i][0] + dp[i-1][1]) % MOD;
            if (i >= 3 && i - 3 < len - 1) {
                dp[i][0] = (dp[i][0] + dp[i-3][1]) % MOD;
            }

            if (i >= 4 && i - 4 < len - 1) {
                dp[i][0] = (dp[i][0] + dp[i-4][1]) % MOD;
            }

            if (i - 1 < len - 1) dp[i][1] = (dp[i][1] + dp[i-1][0]) % MOD;
            if (i >= 2 && i - 2 < len - 1) {
                dp[i][1] = (dp[i][1] + dp[i-2][0]) % MOD;
            }

            if (i >= 4 && i - 4 < len - 1) {
                dp[i][1] = (dp[i][1] + dp[i-4][0]) % MOD;
            }
        }

        long ans = 0;
        for (int i = len - 1; i < len + 3; i++) {
            ans = (ans + dp[i][0] + dp[i][1]) % MOD;
        }

        return (int) (ans % MOD);
    }
    
    public static void main(String[] args) {
        System.out.println(new B_1().ratJump(new int[]{0, 0, 0}));
        System.out.println(new B_1().ratJump(new int[]{0, 0, 1, 0}));
    }

}
