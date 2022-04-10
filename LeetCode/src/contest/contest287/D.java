package contest.contest287;

import java.util.*;

public class D {

    class Encrypter {

        private int[] keysIndexArr;
        private char[] keys;
        private String[] values;
        private Map<String, List<Integer>> valuesIndexMap;

        private Set<String> dictionarySet;

        public Encrypter(char[] keys, String[] values, String[] dictionary) {
            this.keys = keys;
            this.values = values;
            keysIndexArr = new int[26];
            for (int i = 0; i < keys.length; i++) {
                keysIndexArr[keys[i] - 'a'] = i;
            }

            valuesIndexMap = new HashMap<>();
            for (int i = 0; i < values.length; i++) {
                if (!valuesIndexMap.containsKey(values[i])) {
                    valuesIndexMap.put(values[i], new ArrayList<>());
                }
                valuesIndexMap.get(values[i]).add(i);
            }

            dictionarySet = new HashSet<>();
            dictionarySet.addAll(Arrays.asList(dictionary));
        }

        public String encrypt(String word1) {
            char[] arr = word1.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                int indexInKeys = keysIndexArr[arr[i] - 'a'];
                sb.append(values[indexInKeys]);
            }
            return sb.toString();
        }

        private boolean isOk(int wordIdx, int dictIdx, String word, String dict) {
            if (wordIdx == word.length() && dictIdx == dict.length()) {
                return true;
            }

            if (wordIdx == word.length() || dictIdx == dict.length()) {
                return false;
            }

            String subStr = word.substring(wordIdx, wordIdx + 2);
            List<Integer> valuesIndexList = valuesIndexMap.get(subStr);
            if (valuesIndexList == null) {
                if (dictIdx < dict.length() - 1 && subStr.equals(dict.substring(dictIdx, dictIdx + 2))) {
                    return isOk(wordIdx + 2, dictIdx + 2, word, dict);
                }
                return false;
            }

            boolean isFound = false;
            for (Integer valueIdx: valuesIndexList) {
                if (keys[valueIdx] != dict.charAt(dictIdx)) {
                    continue;
                }

                isFound = isOk(wordIdx + 2, dictIdx + 1, word, dict);
                if (isFound) {
                    return true;
                }
            }

            return false;
        }

        public int decrypt(String word2) {
            int count = 0;
            for (String dict: dictionarySet) {
                // 判断是否存在
                if (isOk(0, 0, word2, dict)) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
