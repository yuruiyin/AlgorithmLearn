package contest.contest226;

/**
 * D_1
 *
 * @author: yry
 * @date: 2021/1/31
 */
public class D_1 {

    public boolean checkPartitioning(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        boolean[][] dp = new boolean[n][n];
        for (int l = n - 1; l >= 0; l--) {
            dp[l][l] = true;
            for (int r = l + 1; r < n; r++) {
                if (arr[l] == arr[r]) {
                    dp[l][r] = l + 1 == r || dp[l + 1][r - 1];
                }
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (!dp[0][i - 1]) {
                continue;
            }

            for (int j = i; j < n - 1; j++) {
                if (dp[0][i - 1] && dp[i][j] && dp[j + 1][n - 1]) {
                    return true;
                }
            }
        }

        return false;
    }
}
