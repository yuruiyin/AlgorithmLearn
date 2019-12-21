package problem201_300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem288 {

    class ValidWordAbbr {

        private Map<String, Integer> abbrCountMap;
        private Set<String> wordSet;

        private String getWordAbbr(String word) {
            int len = word.length();
            StringBuilder sb = new StringBuilder();
            if (len <= 2) {
                sb.append(word);
            } else {
                sb.append(word.charAt(0)).append(word.length()).append(word.charAt(len - 1));
            }
            return sb.toString();
        }

        private void createAbbrSet(String[] dictionary) {
            abbrCountMap = new HashMap<>();
            wordSet = new HashSet<>();
            for (String word: dictionary) {
                if (wordSet.contains(word)) {
                    continue;
                }
                wordSet.add(word);
                String abbr = getWordAbbr(word);
                abbrCountMap.put(abbr, abbrCountMap.getOrDefault(abbr, 0) + 1);
            }
        }

        public ValidWordAbbr(String[] dictionary) {
            createAbbrSet(dictionary);
        }

        public boolean isUnique(String word) {
            String abbr = getWordAbbr(word);
            return wordSet.contains(word) && abbrCountMap.get(abbr) == 1 ||
                    !wordSet.contains(word) && !abbrCountMap.containsKey(abbr);
        }
    }

}
