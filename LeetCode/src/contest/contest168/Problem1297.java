package contest.contest168;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1297 {

//    private boolean isMatch(String str, int maxLetters) {
//        Set<Character> set = new HashSet<>();
//        for (char c : str.toCharArray()) {
//            set.add(c);
//            if (set.size() > maxLetters) {
//                return false;
//            }
//        }
//
//        return set.size() <= maxLetters;
//    }

    private boolean isMatch(String str, int maxLetters) {
        int[] countArr = new int[26];
        for (char c : str.toCharArray()) {
            countArr[c - 'a']++;
        }

        int diffCount = 0;
        for (int i = 0; i < 26; i++) {
            if (countArr[i] > 0) {
                diffCount++;
            }
        }

        return diffCount <= maxLetters;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int len = s.length();
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (i + minSize > len) {
                break;
            }

            String sub = s.substring(i, i + minSize);
            if (isMatch(sub, maxLetters)) {
                countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
            }
        }

        int ansMax = 0;
        for (String str: countMap.keySet()) {
            int count = countMap.get(str);
            if (count > ansMax) {
                ansMax = count;
            }
        }

        return ansMax;
    }
    
    public static void main(String[] args) {
        
    }
    
}
