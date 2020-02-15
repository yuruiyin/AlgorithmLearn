package lcof;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lcof050 {

    public char firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        if (len == 0) {
            return ' ';
        }

        Map<Character, Integer> countMap = new LinkedHashMap<>();

        for (char c: arr) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (Character c : countMap.keySet()) {
            if (countMap.get(c) == 1) {
                return c;
            }
        }

        return ' ';
    }

}
