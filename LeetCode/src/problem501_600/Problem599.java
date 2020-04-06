package problem501_600;

import java.util.*;

/**
 * Problem599
 *
 * @author: yry
 * @date: 2020/4/4
 */
public class Problem599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            indexMap.put(list1[i], i);
        }

        int minIdxSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (indexMap.containsKey(list2[i])) {
                minIdxSum = Math.min(minIdxSum, indexMap.get(list2[i]) + i);
            }
            if (i > minIdxSum) {
                break;
            }
        }

        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (indexMap.containsKey(list2[i])) {
                if (indexMap.get(list2[i]) + i == minIdxSum) {
                    ansList.add(list2[i]);
                }
            }
        }

        String[] ansArr = new String[ansList.size()];
        return ansList.toArray(ansArr);
    }

}
