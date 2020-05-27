package contest.contest190;

import java.util.Arrays;

/**
 * D_1
 *
 * @author: yry
 * @date: 2020/5/24
 */
public class D_1 {

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            Arrays.fill(dp[i], (int) -1e8);
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 选当前元素
                dp[i][j] = Math.max(dp[i][j], nums1[i-1] * nums2[j-1]);
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + nums1[i-1] * nums2[j-1]);
                // 不选当前元素
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
            }
        }

        return dp[len1][len2];
    }

}
