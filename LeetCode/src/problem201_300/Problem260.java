package problem201_300;

import java.util.HashMap;
import java.util.Map;

public class Problem260 {

    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[2];
        int index = 0;
        for (Integer num : countMap.keySet()) {
            if (countMap.get(num) == 1) {
                ans[index++] = num;
                if (index == 2) {
                    return ans;
                }
            }
        }

        return ans;
    }

}
