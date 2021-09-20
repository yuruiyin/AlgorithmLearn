package contest.contest250;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/18
 */
public class C_1 {

    public long maxPoints(int[][] points) {
        long ansMax = 0;
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];
        if (m < n) {
            for (int j = n - 1; j >= 0; j--) {
                for (int i = 0; i < m; i++) {
                    if (j == n - 1) {
                        dp[i][j] = points[i][j];
                    } else {
                        long max = 0;
                        long sameValue = 0;
                        for (int ii = 0; ii < m; ii++) {
                            if (ii == i) {
                                sameValue = dp[ii][j + 1];
                                continue;
                            }
                            max = Math.max(max, dp[ii][j + 1] - 1);
                        }

                        dp[i][j] = Math.max(max + points[i][j], sameValue);
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                ansMax = Math.max(ansMax, dp[i][0]);
            }
        } else {
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1) {
                        dp[i][j] = points[i][j];
                    } else {
                        for (int jj = 0; jj < n; jj++) {
                            dp[i][j] = Math.max(dp[i][j], dp[i + 1][jj] - Math.abs(jj - j));
                        }
                        dp[i][j] += points[i][j];
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                ansMax = Math.max(ansMax, dp[0][j]);
            }
        }

        return ansMax;

    }

    public static void main(String[] args) {
        System.out.println(new C_1().maxPoints(new int[][]{
                {1, 2, 3}
        }));
    }

}
