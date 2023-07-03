package doubleContest.round101;

import java.util.Arrays;

public class B {

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        char[] charArr = chars.toCharArray();
        int len1 = charArr.length;
        int[] cost = new int[26];
        for (int i = 0; i < 26; i++) {
            cost[i] = i + 1;
        }
        for (int i = 0; i < len1; i++) {
            cost[charArr[i] - 'a'] = vals[i];
        }
        int ansMax = 0;
        int preMin = 0;
        int pre = 0;
        for (int i = 0; i < len; i++) {
            pre += cost[arr[i] - 'a'];
            ansMax = Math.max(ansMax, pre - preMin);
            preMin = Math.min(preMin, pre);
        }
        return ansMax;
    }

}
