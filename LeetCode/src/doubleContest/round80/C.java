package doubleContest.round80;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class C {

    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        char[] sArr = s.toCharArray();
        int sLen = sArr.length;
        char[] subArr = sub.toCharArray();
        int subLen = subArr.length;
        Map<Character, Set<Character>> map = new HashMap<>();
        for (char[] mapping : mappings) {
            char from = mapping[0];
            char to = mapping[1];
            if (!map.containsKey(from)) {
                map.put(from, new HashSet<>());
            }
            map.get(from).add(to);
        }

        for (int i = 0; i < sLen && sLen - i >= subLen; i++) {
            boolean isOk = true;
            for (int j = i; j <= i + subLen - 1; j++) {
                if (sArr[j] != subArr[j - i]) {
                    Set<Character> set = map.get(subArr[j - i]);
                    if (set == null || !set.contains(sArr[j])) {
                        isOk = false;
                        break;
                    }
                }
            }
            if (isOk) {
                return true;
            }
        }
        return false;
    }

}
