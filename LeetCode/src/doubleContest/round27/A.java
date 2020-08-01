package doubleContest.round27;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/30
 */
public class A {

    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> targetCountMap = new HashMap<>();
        for (int num : target) {
            targetCountMap.put(num, targetCountMap.getOrDefault(num, 0) + 1);
        }

        for (Integer key : countMap.keySet()) {
            if (!countMap.get(key).equals(targetCountMap.getOrDefault(key, 0))) {
                return false;
            }
        }
        return true;
    }

}
