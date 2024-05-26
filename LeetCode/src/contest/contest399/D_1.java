package contest.contest399;

import java.util.Arrays;

public class D_1 {

    private static final int MOD = (int) (1e9 + 7);

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }
        if (len == 1) {
            long ans = 0;
            for (int[] q : queries) {
                int pos = q[0];
                nums[pos] = Math.max(0, q[1]);
                ans = (ans + nums[pos]) % MOD;
            }
            return (int) ans;
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        long ans = 0;
        for (int[] q : queries) {
            int pos = q[0];
            nums[pos] = Math.max(0, q[1]);
            if (pos == 0) {
                dp[pos] = nums[pos];
                dp[1] = Math.max(nums[0], nums[1]);
                for (int i = pos + 2; i < len; i++) {
                    dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
                }
            } else if (pos == 1) {
                dp[pos] = Math.max(nums[0], nums[pos]);
                for (int i = pos + 1; i < len; i++) {
                    dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
                }
            } else {
                dp[pos] = Math.max(dp[pos - 1], dp[pos - 2] + nums[pos]);
                for (int i = pos + 1; i < len; i++) {
                    dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
                }
            }

            ans += Math.max(dp[len - 1], dp[len - 2]);
        }

        return (int) (ans % MOD);
    }

    private static int[] createNums() {
        int[] ans = new int[50000];
        Arrays.fill(ans, 100000);
        return ans;
    }

    private static int[][] createQ() {
        int[][] q = new int[50000][2];
        for (int i = 0; i < 50000; i++) {
            q[i] = new int[]{0, 1000};
        }
        return q;
    }

    public static void main(String[] args) {
        int[] nums = createNums();
        int[][] queries = createQ();
        long start = System.currentTimeMillis();
        System.out.println(new D_1().maximumSumSubsequence(nums, queries));
        System.out.println("time cost: " + (System.currentTimeMillis() - start) + "ms");
    }

}
