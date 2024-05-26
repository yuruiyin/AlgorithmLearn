package contest.contest382;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class B {

    public int maximumLength(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> numSet = countMap.keySet();
        int ansMax = 1;
        if (numSet.contains(1)) {
            int count = countMap.get(1);
            ansMax = count % 2 == 0 ? count - 1 : count;
        }
        for (int num : numSet) {
            if (num == 1) {
                continue;
            }
            int count = 0;
            boolean isFound = false;
            while (num <= maxNum) {
                int tmpCount = countMap.getOrDefault(num, 0);
                if (tmpCount == 0) {
                    count--;
                    isFound = true;
                    break;
                } else if (tmpCount == 1) {
                    count++;
                    isFound = true;
                    break;
                } else {
                    count += 2;
                }
                num *= num;
            }
            ansMax = Math.max(ansMax, isFound ? count : count - 1);
        }
        return ansMax;
    }

}
