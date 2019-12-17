package problem201_300;

import java.util.*;

public class Problem244 {

    class WordDistance {

        private String[] words;
        private Map<String, List<Integer>> indexListMap;

        public WordDistance(String[] words) {
            this.words = words;
            createWordIndexListMap();
        }

        private void createWordIndexListMap() {
            indexListMap = new HashMap<>();
            int len = words.length;

            for (int i = 0; i < len; i++) {
                String word = words[i];
                if (!indexListMap.containsKey(word)) {
                    indexListMap.put(word, new ArrayList<>());
                }
                indexListMap.get(word).add(i);
            }
        }

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

        public int shortest(String word1, String word2) {
            List<Integer> indexList1 = indexListMap.get(word1);
            List<Integer> indexList2 = indexListMap.get(word2);

            int min = Integer.MAX_VALUE;
            for (Integer index1 : indexList1) {
                int distance = find(indexList2, index1);
                if (distance < min) {
                    min = distance;
                }
            }

            return min;
        }
    }

}
