package lcci;

import java.util.*;

public class Lcci1002 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ansList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(word);
            } else {
                List<String> list = new ArrayList<>(Collections.singletonList(word));
                ansList.add(list);
                map.put(sortedStr, list);
            }
        }

        return ansList;
    }

}
