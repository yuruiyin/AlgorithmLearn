package problem101_200;

import java.util.Arrays;

public class Problem132 {

    private int sLen;
    private boolean[][] isPaliArr;  //预处理各个区间是否为回文
    private int[] memo;

    private boolean isPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        int mid = (start + end) >>> 1;
        for (int i = start; i <= mid; i++) {
            if (s.charAt(i) != s.charAt(end - i + start)) {
                return false;
            }
        }
        return true;
    }

    private void calcPali(String s) {
        isPaliArr = new boolean[sLen][sLen];
        for (int i = 0; i < sLen; i++) {
            for (int j = i; j < sLen; j++) {
                isPaliArr[i][j] = isPalindrome(s, i, j);
            }
        }
    }

    private int backTrack(String s, int start) {
        if (start == sLen) {
            return 0;
        }

        if (isPaliArr[start][sLen-1]) {
            return 1;
        }

        if (memo[start] != -1) {
            return memo[start];
        }

        int minCount = Integer.MAX_VALUE;
        for (int end = start; end < sLen; end++) {
            if (isPaliArr[start][end]) {
                int count = backTrack(s, end+1) + 1;
                if (count < minCount) {
                    minCount = count;
                }
            }
        }

        memo[start] = minCount;

        return minCount;
    }

    public int minCut(String s) {
        sLen = s.length();
        calcPali(s);

        // 字符串已经是回文串了，无需分割
        if (isPaliArr[0][sLen-1]) {
            return 0;
        }

        memo = new int[sLen];
        Arrays.fill(memo, -1);
        return backTrack(s, 0) - 1;
    }
}
