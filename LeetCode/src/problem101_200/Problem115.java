package problem101_200;

import java.util.*;

/**
 * 回溯+备忘录+二分
 * 其中二分用于快速定位当前字符在S中的位置
 */
public class Problem115 {

    private List<Integer>[] indexListMap;
    private char[] tArr;
    private int sLen;
    private int tLen;
    private int[][] memo;

    private int findFirstEqualOrBigger(List<Integer> indexList, int target) {
        int low = 0;
        int high = indexList.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = indexList.get(mid);

            if (target <= midVal) {
                if (mid == 0 || indexList.get(mid - 1) < target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

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

        int fromIndex = findFirstEqualOrBigger(indexList, sFrom);
        if (fromIndex == -1) {
            memo[sFrom][tFrom] = 0;
            return 0;
        }

        int indexListSize = indexList.size();
        int sum = 0;
        for (int i = fromIndex; i < indexListSize; i++) {
            int sIndex = indexList.get(i);
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

    public static void main(String[] args) {

    }
    
}
