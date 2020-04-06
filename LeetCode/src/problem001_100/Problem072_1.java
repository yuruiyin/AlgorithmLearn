package problem001_100;

import java.util.Map;

/**
 * Problem072_1
 *
 * @author: yry
 * @date: 2020/4/6
 */
public class Problem072_1 {

    private char[] arr1;
    private char[] arr2;
    private int len1;
    private int len2;
    private Integer[][] memo;

    private int dp(int idx1, int idx2) {
        if (idx2 == len2) {
            return len1 - idx1; // 把第一个单词后面的字幕全删了
        }

        if (idx1 == len1) {
            return len2 - idx2; // 需要在第一个单词后面插入第二个单词剩下的字符
        }

        if (memo[idx1][idx2] != null) {
            return memo[idx1][idx2];
        }

        // 当前字符相等，指针都往右移动一位
        if (arr1[idx1] == arr2[idx2]) {
            memo[idx1][idx2] = dp(idx1 + 1, idx2 + 1);
            return memo[idx1][idx2];
        }

        // 当前字符不相等，则有三种现在，插入、删除、替换
        int insertRes = dp(idx1, idx2 + 1) + 1;
        int deleteRes = dp(idx1 + 1, idx2) + 1;
        int replaceRes = dp(idx1 + 1, idx2 + 1) + 1;
        memo[idx1][idx2] = Math.min(Math.min(insertRes, deleteRes), replaceRes);
        return memo[idx1][idx2];
    }

    public int minDistance(String word1, String word2) {
        len1 = word1.length();
        len2 = word2.length();

        if (len1 == 0) {
            return len2;
        }

        if (len2 == 0) {
            return len1;
        }

        arr1 = word1.toCharArray();
        arr2 = word2.toCharArray();

        memo = new Integer[len1][len2];
        return dp(0, 0);
    }

}
