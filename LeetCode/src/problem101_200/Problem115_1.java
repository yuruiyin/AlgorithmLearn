package problem101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯+备忘录  非二分
 */
public class Problem115_1 {

    private List<Integer>[] indexListMap;
    private char[] tArr;
    private int sLen;
    private int tLen;
    private int[][] memo;

    private int backTrack(int sFrom, int tFrom) {
        if (tFrom == tLen) {
            return 1;
        }

        if (sFrom == sLen) {
            return 0;
        }

        if (memo[sFrom][tFrom] != -1) {
            return memo[sFrom][tFrom];
        }

        char c = tArr[tFrom];
        if (indexListMap[c] == null || indexListMap[c].isEmpty()) {
            memo[sFrom][tFrom] = 0;
            return 0;
        }

        List<Integer> indexList = indexListMap[c];
        int sum = 0;
        for (int sIndex : indexList) {
            if (sIndex < sFrom) {
                continue;
            }
            sum += backTrack(sIndex + 1, tFrom + 1);
        }

        memo[sFrom][tFrom] = sum;

        return sum;
    }

    public int numDistinct(String s, String t) {
        indexListMap = new ArrayList[128];

        char[] sArr = s.toCharArray();
        tArr = t.toCharArray();
        sLen = sArr.length;
        tLen = tArr.length;

        for (int i = 0; i < sArr.length; i++) {
            char c = sArr[i];
            if (indexListMap[c] == null) {
                indexListMap[c] = new ArrayList<>();
            }

            indexListMap[c].add(i);
        }

        memo = new int[sLen][tLen];
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < tLen; j++) {
                memo[i][j] = -1;
            }
        }
        return backTrack(0, 0);
    }

}
