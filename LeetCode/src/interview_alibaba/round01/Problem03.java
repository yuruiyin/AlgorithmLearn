package interview_alibaba.round01;

import java.util.HashMap;
import java.util.Map;

public class Problem03 {

    /**
     * 判断map1与map2是否有相同的keyset，而且map1 values > map2 values
     */
    private boolean isMatch(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Character key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                return false;
            }

            if (map1.get(key) < map2.get(key)) {
                return false;
            }
        }

        return true;
    }

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        Map<Character, Integer> tCountMap = new HashMap<>();

        for (int i = 0; i < tLen; i++) {
            char key = t.charAt(i);
            if (key >= 'a' && key <= 'z' || key >= 'A' && key <= 'Z') {
                if (tCountMap.containsKey(key)) {
                    tCountMap.put(t.charAt(i), tCountMap.get(key) + 1);
                } else {
                    tCountMap.put(t.charAt(i), 1);
                }
            }
        }

        int[] indexArr = new int[sLen];
        int indexCount = 0;
        Map<Character, Integer> sCountMap = new HashMap<>();
        for (int i = 0; i < sLen; i++) {
            char key = s.charAt(i);
            if (tCountMap.containsKey(key)) {
                indexArr[indexCount++] = i;
                sCountMap.put(key, sCountMap.containsKey(key) ? sCountMap.get(key) + 1 : 1);
            }
        }

        for (Character character : tCountMap.keySet()) {
            if (!sCountMap.containsKey(character) || sCountMap.get(character) < tCountMap.get(character)) {
                return "";
            }
        }

        // 滑动窗口
        int left = 0;
        int right = 0;
        int ansLeft = 0, ansRight = 0;
        int minLen = Integer.MAX_VALUE;

        Map<Character, Integer> countMap = new HashMap<>();
        countMap.put(s.charAt(indexArr[right]), 1);

        while (left <= right && right <= indexCount - 1) {
            if (isMatch(countMap, tCountMap)) {
                int len = indexArr[right] - indexArr[left] + 1;
                if (len < minLen) {
                    minLen = len;
                    ansLeft = indexArr[left];
                    ansRight = indexArr[right];
                }

                // left指针右移
                char leftKey = s.charAt(indexArr[left]);
                countMap.put(leftKey, countMap.get(leftKey) - 1);
                left++;
            } else {
                // right指针右移
                right++;
                if (right > indexCount - 1) {
                    break;
                }
                char rightKey = s.charAt(indexArr[right]);
                if (countMap.containsKey(rightKey)) {
                    countMap.put(rightKey, countMap.get(rightKey) + 1);
                } else {
                    countMap.put(rightKey, 1);
                }
            }
        }

        return s.substring(ansLeft, ansRight + 1);

    }

    public static void main(String[] args) {
//        System.out.println(new Problem5081().minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(new Problem5081().minWindow("a", "aa"));
//        System.out.println(new Problem5081().minWindow("cabwefgewcwaefgcf", "cae"));
//        System.out.println(new Problem5081().minWindow("ask_not_what_your_country_can_do_for_you_ask_what_you_can_do_for_your_country", "ask_country"));
        System.out.println(new Problem03().minWindow("aa", "aa"));

    }

}
