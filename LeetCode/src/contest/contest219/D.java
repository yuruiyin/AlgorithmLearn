package contest.contest219;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/13
 */
public class D {

    public int maxHeight(int[][] cuboids) {
        int len = cuboids.length;
        for (int i = 0; i < len; i++) {
            Arrays.sort(cuboids[i]);
        }

        // 按高度排序
        Arrays.sort(cuboids, (o1, o2) -> o1[2] == o2[2] ? (o1[1] == o2[1] ? (o1[0] - o2[0]) : o1[1] - o2[1]) : o1[2] - o2[2]);

        int[] dp = new int[len];
        dp[0] = cuboids[0][2];

        for (int i = 1; i < len; i++) {
            int[] cur = cuboids[i];
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                int[] tmp = cuboids[j];
                if (cur[0] >= tmp[0] && cur[1] >= tmp[1]) {
                    max = Math.max(max, dp[j] + cur[2]);
                }
            }

            dp[i] = Math.max(max, cur[2]);
        }

        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            ansMax = Math.max(ansMax, dp[i]);
        }

        return ansMax;

    }

}
