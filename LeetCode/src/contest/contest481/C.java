package contest.contest481;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C {

    public int minSwaps(int[] nums, int[] forbidden) {
        int len = nums.length;
        Map<Integer, Integer> sameValCountMap = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == forbidden[i]) {
                sameValCountMap.put(nums[i], sameValCountMap.getOrDefault(nums[i], 0) + 1);
                sum++;
            }
        }

        if (sum == 0) {
            return 0;
        }

        int maxCount = 0;
        int maxVal = -1;
        for (int key : sameValCountMap.keySet()) {
            int count = sameValCountMap.get(key);
            if (count > maxCount) {
                maxCount = count;
                maxVal = key;
            }
        }

        if (maxCount == sum - maxCount) {
            return maxCount;
        }

        if (maxCount > sum - maxCount) {
            int left = maxCount - (sum - maxCount);
            int canSwapCount = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] != forbidden[i]) {
                    if (nums[i] != maxVal && forbidden[i] != maxVal) {
                        canSwapCount++;
                        if (canSwapCount == left) {
                            break;
                        }
                    }
                }
            }

            if (canSwapCount == left) {
                return left + (sum - maxCount);
            }
            return -1;
        }

        if (sum % 2 == 0) {
            return sum / 2;
        }

        int sameValDiffCount = sameValCountMap.keySet().size();

        // 奇数的情况下，必定剩下一个，可以是任意的一个
        for (int i = 0; i < len; i++) {
            if (nums[i] != forbidden[i]) {
                if (sameValDiffCount >= 3) {
                    return sum / 2 + 1;
                }

                for (int val: sameValCountMap.keySet()) {
                    if (val != nums[i] && val != forbidden[i]) {
                        return sum / 2 + 1;
                    }
                }
            }
        }

        return sameValDiffCount >= 3 ? sum / 2 + 1 : -1;

    }

    public static void main(String[] args) {
//        System.out.println(new C().minSwaps(new int[]{1, 4, 8}, new int[]{1, 4, 8}));
//        System.out.println(new C().minSwaps(new int[]{1}, new int[]{1}));
        System.out.println(new C().minSwaps(new int[]{19,11,4,19}, new int[]{19,11,6,19}));
    }

}
