package contest.contest097;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem884 {

    private Map<String, Integer> createCount(String[] arr) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : arr) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        return countMap;
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");

        Map<String, Integer> countMap1 = createCount(arr1);
        Map<String, Integer> countMap2 = createCount(arr2);

        List<String> ansList = new ArrayList<>();

        for (String word : countMap1.keySet()) {
            if (countMap1.get(word) == 1 && !countMap2.containsKey(word)) {
                ansList.add(word);
            }
        }

        for (String word : countMap2.keySet()) {
            if (countMap2.get(word) == 1 && !countMap1.containsKey(word)) {
                ansList.add(word);
            }
        }

        int size = ansList.size();
        String[] ansArr = new String[size];

        for (int i = 0; i < size; i++) {
            ansArr[i] = ansList.get(i);
        }

        return ansArr;
    }

}
