package lcci;

import java.util.ArrayList;
import java.util.List;

// TLE
public class Lcci0814 {

    private char[] arr;
    private List<Integer>[][] memo;

    private int getBoolAns(int val1, int val2, char operator) {
        switch (operator) {
            case '&':
                return val1 & val2;
            case '|':
                return val1 | val2;
            case '^':
                return val1 ^ val2;
        }
        return val1 & val2;
    }

    private List<Integer> dp(int start, int end) {
        List<Integer> resList = new ArrayList<>();
        if (memo[start][end] != null) {
            return memo[start][end];
        }

        if (start == end) {
            resList.add(arr[start] - '0');
            return resList;
        }

        for (int nextEnd = start; nextEnd < end; nextEnd+=2) {
            List<Integer> leftResList = dp(start, nextEnd);
            List<Integer> rightResList = dp(nextEnd + 2, end);
            for (Integer leftRes : leftResList) {
                for (Integer rightRes : rightResList) {
                    resList.add(getBoolAns(leftRes, rightRes, arr[nextEnd+1]));
                }
            }
        }

        memo[start][end] = resList;
        return resList;
    }

    public int countEval(String s, int result) {
        arr = s.toCharArray();
        int len = arr.length;
        memo = new ArrayList[len][len];
        List<Integer> ansList = dp(0, len - 1);
        int ansCount = 0;
        for (Integer res : ansList) {
            if (res == result) {
                ansCount++;
            }
        }
        return ansCount;
    }

}
