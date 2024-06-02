package contest.contest400;

import java.util.ArrayList;
import java.util.List;

public class D {

    public int minimumDifference(int[] nums, int k) {
//        int minAbs = k;
//        for (int num : nums) {
//            minAbs -= Math.min(minAbs, Math.abs(k - num));
//        }

        int len = nums.length;
        int minAbs = Math.abs(nums[0] - k);
        if (minAbs == 0) {
            return 0;
        }
        List<Integer> diffIdxList = new ArrayList<>();
        diffIdxList.add(0);
        for (int i = 1; i < len; i++) {
            if (nums[i] == k) {
                return 0;
            }
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] < k) {
                // 比k小的话，当前值一定是最接近的
                minAbs = Math.min(minAbs, Math.abs(k - nums[i]));
            } else {
                // nums[i] > k
                minAbs = Math.min(minAbs, Math.abs(k - nums[i]));
                int value = nums[i];
                int max = 32;
                for (int j = diffIdxList.size() - 1; j >= 0; j--, max--) {
                    if (max <= 0) {
                        break;
                    }
                    int idx = diffIdxList.get(j);
                    value = (value & nums[idx]);
                    minAbs = Math.min(minAbs, Math.abs(k - value));
                    if (value <= k) {
                        break;
                    }
                }
            }
            diffIdxList.add(i);
        }
        return minAbs;
    }

}
