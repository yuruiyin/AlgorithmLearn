package contest.contest222;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/3
 */
public class B {

    private static final int MOD = 1000000007;

    public int countPairs(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int len = arr.length;
        countMap.put(arr[0], 1);
        int ansCount = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= 21; j ++) {
                ansCount = (ansCount + countMap.getOrDefault((1 << j) - arr[i], 0)) % MOD;
            }
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }

        return ansCount;
    }

}
