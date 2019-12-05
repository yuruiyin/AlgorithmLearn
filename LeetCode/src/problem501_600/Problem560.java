package problem501_600;

import java.util.HashMap;
import java.util.Map;

public class Problem560 {

    // 先计算以每个元素为结尾的前缀和数组。
    // 使用一个map来存储遍历过程中前面每个以前缀和为key的个数。
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] prevSumArr = new int[len];
        prevSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            prevSumArr[i] = prevSumArr[i-1] + nums[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(prevSumArr[i] - k)) {
                ans += map.get(prevSumArr[i] - k);
            }

            map.put(prevSumArr[i], map.getOrDefault(prevSumArr[i], 0) + 1);
        }

        return ans;
    }

}
