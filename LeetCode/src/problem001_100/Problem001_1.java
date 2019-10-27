package problem001_100;

import utils.PrintUtil;

import java.util.HashMap;
import java.util.Map;

public class Problem001_1 {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            indexMap.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int anotherNum = target - nums[i];
            if (indexMap.containsKey(anotherNum)) {
                int index = indexMap.get(anotherNum);
                if (index != i) {
                    return new int[]{i, indexMap.get(anotherNum)};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] ans = new Problem001_1().twoSum(new int[]{3,3}, 6);
        PrintUtil.printIntArray(ans);
    }

}
