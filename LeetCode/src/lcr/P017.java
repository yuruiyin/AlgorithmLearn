package lcr;

import java.util.HashMap;
import java.util.Map;

public class P017 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> tCountMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCountMap.put(c, tCountMap.getOrDefault(c, 0) + 1);
        }

        char[] sArr = s.toCharArray();
        int len = sArr.length;
        Map<Character, Integer> copyTCountMap = new HashMap<>(tCountMap);
        Map<Character, Integer> tmpCountMap = new HashMap<>();
        int e = -1;
        for (int i = 0; i < len; i++) {
            char c = sArr[i];
            tmpCountMap.put(c, tmpCountMap.getOrDefault(c, 0) + 1);
            if (copyTCountMap.containsKey(c)) {
                int preCount = copyTCountMap.get(c);
                if (preCount == 1) {
                    copyTCountMap.remove(c);
                    if (copyTCountMap.isEmpty()) {
                        e = i;
                        break;
                    }
                } else {
                    copyTCountMap.put(c, preCount - 1);
                }
            }
        }

        if (e == -1) {
            // 找不到
            return "";
        }

        int ansS = 0;
        int ansE = e;

        int curS = 0;
        int curE = e;

        for (int i = 1; i < len; i++) {
            char preC = sArr[i - 1];
            int sCount = tmpCountMap.getOrDefault(preC, 0);
            tmpCountMap.put(preC, sCount - 1);
            int tCount = tCountMap.getOrDefault(preC, 0);
            if (sCount - 1 >= tCount) {
                curS = i;
                if (curE - curS < ansE - ansS) {
                    ansS = curS;
                    ansE = curE;
                }
                continue;
            }

            // 找到下一个preC
            boolean isOk = false;
            for (int j = curE + 1; j < len; j++) {
                char c = sArr[j];
                tmpCountMap.put(c, tmpCountMap.getOrDefault(c, 0) + 1);
                if (c == preC) {
                    isOk = true;
                    curE = j;
                    if (curE - curS < ansE - ansS) {
                        ansS = curS;
                        ansE = curE;
                    }
                    break;
                }
            }

            if (!isOk) {
                break;
            }
        }

        return s.substring(ansS, ansE + 1);
    }

    public static void main(String[] args) {

    }

}
