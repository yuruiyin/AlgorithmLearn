package problem201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem243 {

    private int find(List<Integer> list, int target) {
        int size = list.size();
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid);
            if (target > midVal) {
                if (mid == size - 1) {
                    return target - midVal;
                } else if (list.get(mid + 1) > target) {
                    return Math.min(target - midVal, list.get(mid + 1) - target);
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return list.get(0) - target;
    }

    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> indexListMap = new HashMap<>();
        int len = words.length;

        for (int i = 0; i < len; i++) {
            String word = words[i];
            if (word.equals(word1) || word.equals(word2)) {
                if (!indexListMap.containsKey(word)) {
                    indexListMap.put(word, new ArrayList<>());
                }
                indexListMap.get(word).add(i);
            }
        }

        List<Integer> word1IndexList = indexListMap.get(word1);
        List<Integer> word2IndexList = indexListMap.get(word2);

        int min = Integer.MAX_VALUE;
        for (Integer index1 : word1IndexList) {
            int distance = find(word2IndexList, index1);
            if (distance < min) {
                min = distance;
            }
        }

        return min;
    }

}
