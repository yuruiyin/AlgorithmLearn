package problem501_600;

import java.util.Arrays;

/**
 * Problem525
 *
 * @author: yry
 * @date: 2020/4/11
 */
public class Problem525 {

    public int findMaxLength(int[] nums) {
        int[] indexMap = new int[100001];
        Arrays.fill(indexMap, -1);
        int diff = 50000; // 1比0多几个
        int ansMax = 0;
        for (int i = 0; i < nums.length; i++) {
            diff += nums[i] == 1 ? 1 : -1;
            if (diff == 50000) {
                ansMax = Math.max(ansMax, i + 1);
                continue;
            }

            if (indexMap[diff] != -1) {
                ansMax = Math.max(ansMax, i - indexMap[diff]);
            } else {
                indexMap[diff] = i;
            }
        }

        return ansMax;
    }

}
