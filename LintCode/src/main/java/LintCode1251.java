import java.util.Arrays;

/**
 * LintCode1251
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode1251 {

    private int[] arr;
    private int len;
    private int[][] memo;

    private int dp(int idx, int m) {
        if (idx == len) {
            return m == 0 ? 0 : Integer.MAX_VALUE;
        }

        if (len - idx < m || m <= 0) {
            return Integer.MAX_VALUE;
        }

        if (memo[idx][m] != -1) {
            return memo[idx][m];
        }

        int ansMin = Integer.MAX_VALUE;
        int preSum = 0;
        for (int i = idx; i < len; i++) {
            preSum += arr[i];
            int curMax = Math.max(preSum, dp(i + 1, m - 1));
            ansMin = Math.min(ansMin, curMax);
        }

        memo[idx][m] = ansMin;
        return ansMin;
    }

    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        arr = nums;
        len = arr.length;
        memo = new int[len][m + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, m);
    }

    public static void main(String[] args) {
        System.out.println(new LintCode1251().splitArray(new int[]{2, 7, 5}, 2));
    }

}
