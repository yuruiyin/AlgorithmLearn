package problem001_100;

import java.util.HashMap;
import java.util.Map;

// 使用java 11
public class Problem001_3 {

    public int[] twoSum(int[] nums, int target) {
        var indexMap = new HashMap<Integer, Integer>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int value = target - nums[i];
            if (indexMap.containsKey(value)) {
                return new int[]{indexMap.get(value), i};
            } else {
                indexMap.put(nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
    
}
