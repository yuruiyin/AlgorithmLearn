package doubleContest.round62;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/2
 */
public class D {

    public int waysToPartition(int[] nums, int k) {
        int len = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int ans = 0;
        if (sum % 2 == 0) {
            // 和为偶数才有相等的可能
            long preSum = 0;
            int count = 0;
            for (int i = 0; i < len - 1; i++) {
                preSum += nums[i];
                if (preSum == sum / 2) {
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }

        Map<Long, Integer> countMap = new HashMap<>();
        long[] preSumArr = new long[len - 1];
        preSumArr[0] = nums[0];
        countMap.put(preSumArr[0], 1);
        for (int i = 1; i < len - 1; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
            countMap.put(preSumArr[i], countMap.getOrDefault(preSumArr[i], 0) + 1);
        }

        // 修改最后一个元素
        long diff = k - nums[len - 1];
        if ((sum + diff) % 2 == 0) {
            long half = (sum + diff) / 2;
            ans = Math.max(ans, countMap.getOrDefault(half, 0));
        }

        Map<Long, Integer> countMap2 = new HashMap<>();
        for (int i = len - 2; i >= 0; i--) {
            diff = k - nums[i];
            countMap2.put(preSumArr[i], countMap2.getOrDefault(preSumArr[i], 0) + 1);
            countMap.put(preSumArr[i], countMap.get(preSumArr[i]) - 1);
            if ((sum + diff) % 2 != 0) {
                continue;
            }

            long half = (sum + diff) / 2;
            int count = countMap.getOrDefault(half, 0) + countMap2.getOrDefault(half - diff, 0);
            ans = Math.max(ans, count);
        }

        return ans;
    }

    public static void main(String[] args) {
        
    }

}
