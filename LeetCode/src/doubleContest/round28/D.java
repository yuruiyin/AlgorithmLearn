package doubleContest.round28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/13
 */
public class D {

    private final static int MAX = 1000000000;

    private int len;
    private Map<Integer, Integer> memo;
    private int[] houses;

    // k个邮筒建在house上可以保证得到最小值
    private int dp(int preChooseIdx, int preNoChooseIdx, int idx, int k) {
        if (k == 0) {
            int res = 0;
            int from = preNoChooseIdx == len ? idx : preNoChooseIdx;
            for (int i = from; i < len; i++) {
                res += houses[i] - houses[preChooseIdx];
            }
            return res;
        }

        if (idx == len) {
            return MAX;
        }

        if (len - idx < k) {
            return MAX;
        }

        int key = preChooseIdx * 1000000 + preNoChooseIdx * 10000 + idx * 100 + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int chooseRes = dp(idx, len,idx + 1, k - 1);
        if (preNoChooseIdx != len) {
            for (int i = preNoChooseIdx; i < idx; i++) {
                chooseRes += houses[idx] - houses[i];
            }
        }

        // 跟前面
        int nonChooseRes1 = 0;
        if (preChooseIdx != len) {
            int from = idx;
            if (preNoChooseIdx != len) {
                from = preNoChooseIdx;
            }

            for (int i = from; i <= idx; i++) {
                nonChooseRes1 += houses[i] - houses[preChooseIdx];
            }
        }

        nonChooseRes1 += dp(preChooseIdx, preChooseIdx == len ? Math.min(preNoChooseIdx, idx) : len, idx + 1, k);

        // 跟后面
        int nonChooseRes2 = dp(preChooseIdx, preNoChooseIdx == len ? idx : preNoChooseIdx, idx + 1, k);

        int minRes = Math.min(Math.min(nonChooseRes1, nonChooseRes2), chooseRes);

        memo.put(key, minRes);
        return minRes;
    }

    public int minDistance(int[] houses, int k) {
        this.len = houses.length;
        this.houses = houses;

        Arrays.sort(houses);

        if (k == len) {
            return 0;
        }

        memo = new HashMap<>();
        return dp(len, len, 0, k);
    }

}
