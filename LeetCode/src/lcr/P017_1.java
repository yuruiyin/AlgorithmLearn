package lcr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P017_1 {

    public String minWindow(String s, String t) {
        int[] tCountArr = new int[128];
        int tLen = t.length();
        for (char c : t.toCharArray()) {
            tCountArr[c]++;
        }

        char[] sArr = s.toCharArray();
        int len = sArr.length;
        int[] copyTCountArr = Arrays.copyOf(tCountArr, 128);
        int[] tmpCountArr = new int[128];
        int e = -1;
        int tmpSCount = 0;
        for (int i = 0; i < len; i++) {
            char c = sArr[i];
            tmpCountArr[c]++;
            if (copyTCountArr[c] > 0) {
                tmpSCount++;
                copyTCountArr[c]--;
                if (tmpSCount == tLen) {
                    e = i;
                    break;
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
            int sCount = tmpCountArr[preC];
            tmpCountArr[preC]--;
            int tCount = tCountArr[preC];
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
                tmpCountArr[c]++;
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
