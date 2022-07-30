package problem501_600;

import java.util.HashMap;
import java.util.Map;

public class Problem523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 1) {
            return nums.length > 1;
        }
        int len = nums.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, -1);
        int preSum = 0;
        for (int i = 0; i < len; i++) {
            preSum += nums[i];
            if (i >= 1 && preSum == 0) {
                return true;
            }
            int key = (preSum - k) % k;
            if (i - indexMap.getOrDefault(key, i) >= 2 || i - indexMap.getOrDefault(preSum % k, i) >= 2) {
                return true;
            }
            if (!indexMap.containsKey(preSum % k)) {
                indexMap.put(preSum % k, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem523().checkSubarraySum(new int[]{1, 1}, 1));
    }

}
