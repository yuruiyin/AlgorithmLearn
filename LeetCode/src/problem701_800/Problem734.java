package problem701_800;

import java.util.*;

public class Problem734 {

    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        int len1 = words1.length;
        int len2 = words2.length;
        if (len1 != len2) {
            return false;
        }

        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> pair : pairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);

            if (!map.containsKey(word1)) {
                map.put(word1, new HashSet<>());
            }

            map.get(word1).add(word2);

            if (!map.containsKey(word2)) {
                map.put(word2, new HashSet<>());
            }

            map.get(word2).add(word1);
        }

        for (int i = 0; i < len1; i++) {
            if (words1[i].equals(words2[i]) || map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i])) {
                continue;
            }

            return false;
        }

        return true;
    }

}
