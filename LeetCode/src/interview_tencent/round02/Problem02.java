package interview_tencent.round02;

import java.util.HashMap;
import java.util.Map;

public class Problem02 {

    private boolean isMatch(Map<Character, Integer> countMap, Map<Character, Integer> tCountMap) {
        if (tCountMap.keySet().size() != countMap.keySet().size()) {
            return false;
        }

        for (Character c : tCountMap.keySet()) {
            if (!countMap.containsKey(c) || countMap.get(c) < tCountMap.get(c)) {
                return false;
            }
        }

        return true;
    }

    public String minWindow(String s, String t) {
        // 双指针
        int sLen = s.length();
        int tLen = t.length();
        Map<Character, Integer> tCountMap = new HashMap<>();

        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            if (tCountMap.containsKey(c)) {
                tCountMap.put(c, tCountMap.get(c) + 1);
            } else {
                tCountMap.put(c, 1);
            }
        }

        int left = 0;
        int right = 0;
        Map<Character, Integer> tmpCountMap = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int ansLeft = -1;
        int ansRight = -1;
        while (right < sLen && !tCountMap.containsKey(s.charAt(right))) {
            right++;
        }

        if (right == sLen) {
            return "";
        }

        while (left <= right && !tCountMap.containsKey(s.charAt(left))) {
            left++;
        }

        tmpCountMap.put(s.charAt(right), 1);

        while (left <= right && right < sLen) {
            if (isMatch(tmpCountMap, tCountMap)) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                    ansLeft = left;
                    ansRight = right;
                }

                if (minLen == 1) {
                    break;
                }

                char leftChar = s.charAt(left);
                if (tmpCountMap.containsKey(leftChar) && tmpCountMap.get(leftChar) > 1) {
                    tmpCountMap.put(leftChar, tmpCountMap.get(leftChar) - 1);
                } else if (tmpCountMap.containsKey(leftChar) && tmpCountMap.get(leftChar) == 1) {
                    tmpCountMap.remove(leftChar);
                }

                left++;
                while (left <= right && !tCountMap.containsKey(s.charAt(left))) {
                    left++;
                }
            } else {
                // 不匹配
                right++;
                while (right < sLen && !tCountMap.containsKey(s.charAt(right))) {
                    right++;
                }

                if (right == sLen) {
                    break;
                }

                char rightChar = s.charAt(right);
                if (tmpCountMap.containsKey(rightChar)) {
                    tmpCountMap.put(rightChar, tmpCountMap.get(rightChar) + 1);
                } else {
                    tmpCountMap.put(rightChar, 1);
                }
            }
        }

        if (ansLeft == -1) {
            return "";
        }

        return s.substring(ansLeft, ansRight + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Problem02().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Problem02().minWindow("a", "b"));
        System.out.println(new Problem02().minWindow("ab", "b"));
    }

}
