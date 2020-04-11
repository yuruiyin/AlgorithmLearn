package lcci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Lcci1710
 *
 * @author: yry
 * @date: 2020/4/10
 */
public class Lcci1710 {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int half = nums.length / 2;

        for (Integer num : countMap.keySet()) {
            if (countMap.get(num) > half) {
                return num;
            }
        }

        return -1;
    }

}
