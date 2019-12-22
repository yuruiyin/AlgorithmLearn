package problem801_900;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem846 {

    public boolean isNStraightHand(int[] nums, int k) {
        int len = nums.length;

        if (len % k != 0) {
            return false;
        }

        Arrays.sort(nums);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int needKSetCount = len / k;  // 需要的集合数（每个集合个数为k）
        int kCount = 0;   // 以下遍历过程集合数
        for (int num: nums) {
            int curNumCount = countMap.get(num);
            if (curNumCount == 0) {
                // 等于0说明被归到前面集合中了
                continue;
            }

            countMap.put(num, curNumCount - 1);
            for (int i = 1; i < k; i++) {
                int count = countMap.getOrDefault(num + i, 0);
                if (count == 0) {
                    // 等于0就说明以当前num为起点，找不到k个大小的连续集合
                    return false;
                }

                countMap.put(num + i, count - 1);
            }

            kCount++;
            // 当集合数已经达到需要的集合数，说明已经成功了
            if (kCount == needKSetCount) {
                return true;
            }
        }

        return true;
    }

}
