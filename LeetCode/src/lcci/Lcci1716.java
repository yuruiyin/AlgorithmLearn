package lcci;

/**
 * Lcci1716
 *
 * @author: yry
 * @date: 2020/3/24
 */
public class Lcci1716 {

    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][1] = nums[0];  //第二个坐标0代表不选，1代表选

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

}
