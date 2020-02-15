package lcof;

import java.util.HashMap;
import java.util.Map;

public class Lcof039_1 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int len = nums.length;

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > len / 2) {
                return num;
            }
        }

        return -1;
    }

}
