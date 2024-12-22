package doubleContest.round146;

import fall_2020.E;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    public int subsequencesWithMiddleMode(int[] nums) {
        // 两种情况：
        // 1. seq[2] 出现3次，其他任意
        // 2. seq[2] 出现2次，其他都不一样

        int len = nums.length;

        Map<Integer, Integer> preCountMap = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            preCountMap.put(nums[i], preCountMap.getOrDefault(nums[i], 0) + 1);
        }

        Map<Integer, Integer> sufCountMap = new HashMap<>();
        for (int i = len - 1; i >= 2; i--) {
            sufCountMap.put(nums[i], sufCountMap.getOrDefault(nums[i], 0) + 1);
        }

        int ans = 0;
        for (int i = 2; i <= len - 3; i++) {
            int midNum = nums[i];
            sufCountMap.put(midNum, sufCountMap.get(midNum) - 1);
            int preCount = preCountMap.getOrDefault(midNum, 0);
            int sufCount = sufCountMap.getOrDefault(midNum, 0);
            Set<Integer> preKeySet = preCountMap.keySet();
            Set<Integer> sufKeySet = sufCountMap.keySet();
            if (preCount + sufCount == 0) {
                // 不可能
                preCountMap.put(midNum, 1);
                continue;
            } else if (preCount == 1 && sufCount == 0) {
                // 中间的数只有2个，其他数都不应该相等
                // 左侧再选一个，右侧选两个（比如保证这三个数是不同的数）
                for (int preNum : preKeySet) {
                    if (preNum == midNum) {
                        continue;
                    }

                    for (int sufNum : sufKeySet) {
                        if (sufNum == preNum) {
                            continue;
                        }
                        ans = (ans + len - i - 1 - sufCountMap.getOrDefault(preNum, 0) - sufCountMap.getOrDefault(sufNum, 0)) % MOD;
                    }
                }
            } else if (preCount == 0 && sufCount == 1) {
                // 中间的数只有2个，其他数都不应该相等
                // 左侧再选2个，右侧选1个（比如保证这三个数是不同的数）
                for (int sufNum : sufKeySet) {
                    if (sufNum == midNum) {
                        continue;
                    }

                    for (int preNum : preKeySet) {
                        if (preNum == sufNum) {
                            continue;
                        }
                        ans = (ans + i - preCountMap.getOrDefault(preNum, 0) - preCountMap.getOrDefault(sufNum, 0)) % MOD;
                    }
                }
            } else {
                // 有三个，就任意
                if (preCount == 0) {
                    // sufCount >= 2
                    ans = (ans + i * (i - 1) * (sufCount - 1) * sufCount / 2) % MOD;
                } else if (sufCount == 0) {
                    // preCount >= 2
                    int rightCount = len - i - 1;
                    ans = (ans + rightCount * (rightCount - 1) * preCount * (preCount - 1) / 2) % MOD;
                } else {
                    int rightCount = len - i - 1;
                    ans = (ans + (i - 1) * (rightCount - 1)) % MOD;

                }
            }
            preCountMap.put(midNum, 1);
        }

        return ans;

    }

}
