package lcci;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Lcci17113
 *
 * @author: yry
 * @date: 2020/3/28
 */
public class Lcci1713 {

    private Set<String> dictSet;
    private String sentence;
    private int len;
    private int[] memo;

    private int dp(int idx) {
        if (idx == len) {
            return 0;
        }

        if (memo[idx] != -1) {
            return memo[idx];
        }

        int ansMin = 1 + dp(idx + 1);
        for (int i = idx; i < len; i++) {
            String subStr = sentence.substring(idx, i + 1);
            if (dictSet.contains(subStr)) {
                ansMin = Math.min(ansMin, dp(i + 1));
            }
        }

        memo[idx] = ansMin;
        return ansMin;
    }

    public int respace(String[] dictionary, String sentence) {
        dictSet = new HashSet<>();
        dictSet.addAll(Arrays.asList(dictionary));
        this.sentence = sentence;
        len = sentence.length();
        memo =  new int[len];
        Arrays.fill(memo, -1);
        return dp(0);
    }

}
