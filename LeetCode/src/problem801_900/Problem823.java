package problem801_900;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem823 {

    private static final int MOD = (int) 1e9 + 7;

    // 思路：某一节点为根的树的个数 = 左子树的个数 * 右子树的个数 + 1
    public int numFactoredBinaryTrees(int[] arr) {
        int len = arr.length;
        long[] dp = new long[len];
        Arrays.fill(dp, 1);
        Arrays.sort(arr);

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            indexMap.put(arr[i], i);
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int value = arr[i] / arr[j];
                    if (indexMap.containsKey(value)) {
                        dp[i] = (dp[i] + dp[j] * dp[indexMap.get(value)]) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        for (long num : dp) {
            ans += num;
        }

        return (int) (ans % MOD);
    }

}
