package problem201_300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem290 {

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] words = str.split(" ");
        char[] patternArr = pattern.toCharArray();
        int patternLen = patternArr.length;
        int wordLen = words.length;

        if (patternLen != wordLen) {
            return false;
        }

        Set<String> set = new HashSet<>();

        for (int i = 0; i < patternLen; i++) {
            if (!map.containsKey(patternArr[i])) {
                if (set.contains(words[i])) {
                    return false;
                }
                map.put(patternArr[i], words[i]);
                set.add(words[i]);
            } else {
                if (!words[i].equals(map.get(patternArr[i]))) {
                    return false;
                }
            }
        }

        return true;
    }

}
