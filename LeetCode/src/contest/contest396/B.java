package contest.contest396;

import java.util.HashMap;
import java.util.Map;

public class B {

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        char[] arr = word.toCharArray();
        int len = arr.length;
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i += k) {
            String key = word.substring(i, i + k);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        int maxCount = 0;
        for (String key : countMap.keySet()) {
            int count = countMap.get(key);
            maxCount = Math.max(maxCount, count);
        }

        return len / k  - maxCount;
    }

}
