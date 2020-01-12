package contest.contest109;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem936_1 {

    private boolean isAllQuestionMark(char[] targetArr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (targetArr[i] != '?') {
                return false;
            }
        }

        return true;
    }

    private boolean isMatch(char[] targetArr, int start, char[] stampArr) {
        int end = start + stampArr.length;
        // 先判断是不是全是问号
        if (isAllQuestionMark(targetArr, start, end)) {
            return false;
        }

        for (int i = start; i < end; i++) {
            if (targetArr[i] != '?' && targetArr[i] != stampArr[i - start]) {
                return false;
            }
        }

        for (int i = start; i < end; i++) {
            targetArr[i] = '?';
        }
        return true;
    }

    public int[] movesToStamp(String stamp, String target) {
        char[] stampArr = stamp.toCharArray();
        char[] targetArr = target.toCharArray();
        int stampLen = stampArr.length;
        int targetLen = targetArr.length;
        List<Integer> ansList = new ArrayList<>();
        int count = 10 * targetLen;
        boolean isOk = false;

        while ((count--) > 0) {
            for (int i = 0; i <= targetLen - stampLen; i++) {
                if (isMatch(targetArr, i, stampArr)) {
                    ansList.add(i);
                }
            }

            if (isAllQuestionMark(targetArr, 0, targetLen)) {
                isOk = true;
                break;
            }
        }

        if (!isOk) {
            return new int[0];
        }

        int size = ansList.size();
        int[] ansArr = new int[size];

        for (int i = size - 1; i >= 0; i--) {
            ansArr[size - i - 1] = ansList.get(i);
        }

        return ansArr;
    }
    
    public static void main(String[] args) {
        int[] ansArr = new Problem936_1().movesToStamp("abc", "ababc");
        PrintUtil.printIntArray(ansArr);
    }

}
