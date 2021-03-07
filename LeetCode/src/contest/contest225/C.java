package contest.contest225;

import java.util.PriorityQueue;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/24
 */
public class C {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] ^ matrix[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] ^ matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i][j];
            }
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heap.add(dp[i][j]);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }

        return heap.peek();
    }

}
