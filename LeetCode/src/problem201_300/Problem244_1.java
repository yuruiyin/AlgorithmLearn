package problem201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem244_1 {

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

        public int shortest(String word1, String word2) {
            List<Integer> indexList1 = indexListMap.get(word1);
            List<Integer> indexList2 = indexListMap.get(word2);

            int min = Integer.MAX_VALUE;
            int size1 = indexList1.size();
            int size2 = indexList2.size();
            int i1 = 0;
            int i2 = 0;

            while (i1 < size1 && i2 < size2) {
                int dis = indexList1.get(i1) - indexList2.get(i2);
                if (dis > 0) {
                    min = Math.min(min, dis);
                    i2++;
                } else  {
                    min = Math.min(min, -dis);
                    i1++;
                }
            }

            return min;
        }
    }

}
