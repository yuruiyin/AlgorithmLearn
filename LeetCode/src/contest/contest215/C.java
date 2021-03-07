package contest.contest215;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/15
 */
public class C {

    public int minOperations(int[] nums, int x) {
        Map<Integer, Integer> preSumIndexMap = new HashMap<>();
        int len = nums.length;
        int sum = 0;
        preSumIndexMap.put(0, 0);
        int ansMinCount = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            preSumIndexMap.put(sum, i + 1);
            if (sum == x) {
                ansMinCount = i + 1;
            }
        }

        sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum > x) {
                if (ansMinCount == Integer.MAX_VALUE) {
                    return -1;
                } else {
                    return ansMinCount;
                }
            }

            int left = x - sum;
            int leftCount = preSumIndexMap.getOrDefault(left, -1);
            int totalCount = leftCount + len - i;
            if (leftCount != -1 &&  totalCount >= 1 && totalCount <= len) {
                ansMinCount = Math.min(ansMinCount, leftCount + len - i);
            }
        }

        return ansMinCount == Integer.MAX_VALUE ? -1 : ansMinCount;
    }

}
