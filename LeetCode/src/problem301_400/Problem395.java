package problem301_400;

import java.util.ArrayList;
import java.util.List;

public class Problem395 {

    private char[] arr;
    private int k;

    private int dfs(int start, int end) {
        if (start > end) {
            return 0;
        }

        int[] countArr = new int[26];

        for (int i = start; i <= end; i++) {
            countArr[arr[i] - 'a']++;
        }

        // 字符个数小于k的字符在索引列表
        List<Integer> countLessThanKCharIndexList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (countArr[arr[i] - 'a'] < k) {
                countLessThanKCharIndexList.add(i);
            }
        }

        if (countLessThanKCharIndexList.isEmpty()) {
            return end - start + 1;
        }

        int maxLen = 0;
        int prev = start;
        for (Integer endIndex: countLessThanKCharIndexList) {
            int len = dfs(prev, endIndex - 1);
            if (len > maxLen) {
                maxLen = len;
            }
            prev = endIndex + 1;
        }

        int lastLen = dfs(prev, end);

        return Math.max(maxLen, lastLen);
    }

    public int longestSubstring(String s, int k) {
        if (k <= 1) {
            return s.length();
        }

        this.arr = s.toCharArray();
        this.k = k;

        return dfs(0, s.length() - 1);
    }

}
