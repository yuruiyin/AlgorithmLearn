package problem901_1000;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem936 {

    private boolean isHasSameChars(char[] stampArr, char[] targetArr) {
        boolean[] mapStamp = new boolean[26];
        boolean[] mapTarget = new boolean[26];

        for (char c : stampArr) {
            mapStamp[c - 'a'] = true;
        }

        for (char c : targetArr) {
            mapTarget[c - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (mapStamp[i] != mapTarget[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] listToArr(List<Integer> list) {
        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int[] movesToStamp(String stamp, String target) {
        char[] stampArr = stamp.toCharArray();
        char[] targetArr = target.toCharArray();
        int stampLen = stampArr.length;
        int targetLen = targetArr.length;
        char stampStart = stampArr[0];
        char stampEnd = stampArr[stampLen - 1];
        char targetStart = targetArr[0];
        char targetEnd = targetArr[targetLen - 1];

        if (!(stampStart == targetStart && stampEnd == targetEnd)) {
            // 头和头，尾和尾必须相等。不然印不出序列的。
            return new int[0];
        }

        if (!isHasSameChars(stampArr, targetArr)) {
            return new int[0];
        }

        if (stamp.equals(target)) {
            return new int[]{0};
        }

        // 倒退法，即从target中不断的找到stamp，找到的话就变成？,?当成通配符（可匹配任意字符）。直到找不到位置，最后如果全部变成？，就说明成功。
        List<Integer> ansList = new ArrayList<>();
        int count = 0;
        while (count < 10 * targetLen) {
            boolean isMatched = false;
            for (int i = 0; i <= targetLen - stampLen; i++) {
                if (isMatch(stampArr, targetArr, i, i + stampLen)) {
                    toBeQuestionMark(targetArr, i, i + stampLen);
                    ansList.add(i);
                    count++;
                    i = i + stampLen - 1;
                    isMatched = true;
                }
            }

            if (!isMatched) {
                return new int[0];
            }

            if (isAllQuestionMark(targetArr)) {
                Collections.reverse(ansList);
                return listToArr(ansList);
            }
        }

        return new int[0];
    }

    private boolean isAllQuestionMark(char[] targetArr) {
        for (char c : targetArr) {
            if (c != '?') {
                return false;
            }
        }
        return true;
    }

    private void toBeQuestionMark(char[] targetArr, int start, int end) {
        for (int i = start; i < end; i++) {
            targetArr[i] = '?';
        }
    }

    private boolean isMatch(char[] stampArr, char[] targetArr, int start, int end) {
        boolean isAllQuestionMark = true;
        for (int i = start; i < end; i++) {
            if (targetArr[i] != '?' && targetArr[i] != stampArr[i-start]) {
                return false;
            }
            if (targetArr[i] != '?') {
                isAllQuestionMark = false;
            }
        }

        return !isAllQuestionMark;
    }

    public static void main(String[] args) {
        int[] ansArr = new Problem936().movesToStamp("oz", "ooozz");
        PrintUtil.printIntArray(ansArr);
    }

}
