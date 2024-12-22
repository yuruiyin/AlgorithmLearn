package contest.contest425;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class B {

    public boolean isPossibleToRearrange(String s, String t, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        int len = s.length();
        int eachLen = len / k;
        for (int i = 0; i < len; i += eachLen) {
            String subStr = s.substring(i, i + eachLen);
            countMap.put(subStr, countMap.getOrDefault(subStr, 0) + 1);
        }

        for (int i = 0; i < len; i += eachLen) {
            String subStr = t.substring(i, i + eachLen);
            if (countMap.containsKey(subStr)) {
                int count = countMap.get(subStr);
                if (count == 1) {
                    countMap.remove(subStr);
                } else {
                    countMap.put(subStr, count - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
