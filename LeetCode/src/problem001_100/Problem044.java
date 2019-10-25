package problem001_100;

import java.util.Arrays;

public class Problem044 {

    private int[] memo;

    // p的后缀全是*号的字符串起始位置
    private int pSuffixAllStarCharFromIndex;

    private boolean backTrack(String s, String p, int sIndex, int pIndex) {
        int sLen = s.length();
        int pLen = p.length();
        int key = sIndex * pLen + pIndex;

        if (memo[key] != -1) {
            return memo[key] != 0;
        }

        if (sIndex == sLen) {
            // 已经匹配到s的末尾
            if (pIndex == pLen || pIndex >= pSuffixAllStarCharFromIndex) {
                memo[key] = 1;
                return true;
            }

            memo[key] = 0;
            return false;
        }

        if (pIndex == pLen) {
            memo[key] = 0;
            return false;
        }

        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);

        boolean isFound = false;
        if (pChar == '*') {
            for (int i = sIndex; i <= sLen; i++) {
                isFound = backTrack(s, p, i, pIndex + 1);
                if (isFound) {
                    break;
                }
            }
        } else if (pChar == '?') {
            isFound = backTrack(s, p, sIndex + 1, pIndex + 1);
        } else {
            // a-z
            if (pChar == sChar) {
                isFound = backTrack(s, p, sIndex + 1, pIndex + 1);
            }
        }

        memo[key] = isFound ? 1 : 0;
        return isFound;
    }

    /**
     * 计算p的后缀全是“*”号的起始位置
     */
    private void calcPSuffixAllStarCharIndex(String p) {
        int len = p.length();
        for (int i = len - 1; i >= 0; i--) {
            if (p.charAt(i) != '*') {
                pSuffixAllStarCharFromIndex = i + 1;
                return;
            }
        }
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        memo = new int[(sLen + 1) * (pLen + 1) + 1];
        Arrays.fill(memo, -1);
        calcPSuffixAllStarCharIndex(p);
        return backTrack(s, p, 0, 0);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem044().isMatch("aa", "a"));
        System.out.println(new Problem044().isMatch("aa", "*"));
        System.out.println(new Problem044().isMatch("cb", "?a"));
        System.out.println(new Problem044().isMatch("adceb", "*a*b"));
        System.out.println(new Problem044().isMatch("acdcb", "a*c?b"));
        System.out.println(new Problem044().isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*c?b"));

    }
    
}
