package problem501_600;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem525_1
 *
 * @author: yry
 * @date: 2020/4/11
 */
public class Problem525_1 {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int diff = 0;
        int ansMax = 0;
        for (int i = 0; i < nums.length; i++) {
            diff += nums[i] == 1 ? 1: -1;
            if (diff == 0) {
                ansMax = Math.max(ansMax, i + 1);
                continue;
            }

            if (indexMap.containsKey(diff)) {
                ansMax = Math.max(ansMax, i - indexMap.get(diff));
            } else {
                indexMap.put(diff, i);
            }
        }
        return ansMax;
    }

}
