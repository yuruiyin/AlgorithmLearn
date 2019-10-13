package problem1_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem030 {

    private boolean isMatch(String str, Map<String, Integer> wordCountMap, int wordLen) {
        int strLen = str.length();
        Map<String, Integer> tmpCountMap = new HashMap<>();
        for (int i = 0; i < strLen; i += wordLen) {
            String subStr = str.substring(i, i + wordLen);
            if (!wordCountMap.containsKey(subStr)) {
                return false;
            }

            if (tmpCountMap.containsKey(subStr)) {
                if (tmpCountMap.get(subStr) >= wordCountMap.get(subStr)) {
                    return false;
                }
                tmpCountMap.put(subStr, tmpCountMap.get(subStr) + 1);
            } else {
                tmpCountMap.put(subStr, 1);
            }
        }

        for (String key : wordCountMap.keySet()) {
            if (!tmpCountMap.containsKey(key) || !tmpCountMap.get(key).equals(wordCountMap.get(key))) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int sLen = s.length();
        int wordSize = words.length;
        if (sLen == 0 || wordSize == 0) {
            return new ArrayList<>();
        }

        // 单个单词的长度
        int wordLen = words[0].length();

        Map<String, Integer> wordCountMap = new HashMap<>(); // 统计words数组每个word的count

        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        List<Integer> indexList = new ArrayList<>(); //当前index开始的字符串可以匹配到一个word。
        for (int i = 0; i <= sLen - wordLen; i++) {
            if (wordCountMap.containsKey(s.substring(i, i + wordLen))) {
                indexList.add(i);
            }
        }

        List<Integer> ansList = new ArrayList<>();
        int subStrLen = wordSize * wordLen;

        int indexListSize = indexList.size();
        int maxIndex = indexListSize - wordSize;
        int realMaxIndex = sLen - subStrLen;
        for (int i = 0; i <= maxIndex && indexList.get(i) <= realMaxIndex; i++) {
            int index = indexList.get(i);
            if (isMatch(s.substring(index, index + subStrLen), wordCountMap, wordLen)) {
                ansList.add(index);
            }
        }

        return ansList;
    }

    public static void main(String[] args) {
        System.out.println(new Problem030().findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
        System.out.println(new Problem030().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
    }
}
