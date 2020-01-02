package problem801_900;

import java.util.HashMap;
import java.util.Map;

public class Problem873_1 {

    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            indexMap.put(arr[i], i);
        }

        int[][] dp = new int[len][len];
        int max = 0;

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                int thirdNum = arr[i] + arr[j];
                if (!indexMap.containsKey(thirdNum)) {
                    continue;
                }

                int thirdIndex = indexMap.get(thirdNum);
                dp[i][j] = 1 + dp[j][thirdIndex];
                max = Math.max(max, dp[i][j]);
            }
        }

        max += 2;
        return max <= 2 ? 0 : max;
    }


}
