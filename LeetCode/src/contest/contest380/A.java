package contest.contest380;

import java.util.HashMap;
import java.util.Map;

public class A {

    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        for (int key : countMap.keySet()) {
            int count = countMap.get(key);
            if (count > maxCount) {
                maxCount = count;
            }
        }

        int ans = 0;
        for (int key : countMap.keySet()) {
            int count = countMap.get(key);
            if (count == maxCount) {
                ans += count;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
