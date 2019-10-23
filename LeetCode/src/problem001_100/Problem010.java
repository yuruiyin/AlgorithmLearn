package problem001_100;

import java.util.Arrays;

public class Problem010 {

    // 经测试，LeetCode上测试用例的s和p字符串的长度都不会超过30个。
    private int[] memo; // 每个递归函数值的备忘录
    private int[] pLeftSubStrCanEmptyMemo; //isPLeftSubStrCanEmpty函数值的备忘录

    private boolean int2Bool(int x) {
        return x > 0;
    }

    /**
     * p剩下的字符串是否可以省略，只有类似.*a*b*这样的才可省略
     */
    private boolean isPLeftSubStrCanEmpty(String p, int pIndex) {
        if (pLeftSubStrCanEmptyMemo[pIndex] != -1) {
            return int2Bool(pLeftSubStrCanEmptyMemo[pIndex]);
        }

        int pLen = p.length();
        if (p.charAt(pLen - 1) != '*') {
            pLeftSubStrCanEmptyMemo[pIndex] = 0;
            return false;
        }

        for (int i  = pIndex + 1; i < pLen; i+=2) {
            if (p.charAt(i) != '*') {
                pLeftSubStrCanEmptyMemo[pIndex] = 0;
                return false;
            }
        }

        pLeftSubStrCanEmptyMemo[pIndex] = 1;
        return true;
    }

    private boolean backTracking(String s, String p, int sIndex, int pIndex) {
        int key = sIndex * 100 + pIndex;
        if (memo[key] != -1) {
            return int2Bool(memo[key]);
        }
        int sLen = s.length();
        int pLen = p.length();
        if (sIndex == sLen) {
            // 都匹配到结尾，成功
            if (pIndex == pLen || isPLeftSubStrCanEmpty(p, pIndex)) {
                memo[key] = 1;
                return true;
            }
            memo[key] = 0;
            return false;
        }

        if (pIndex == pLen) { // p结束了， s还没结束
            memo[key] = 0;
            return false;
        }

        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);

        boolean isFound = false;

        // pIndex指向的字符不会是*
        if (pChar == '.') {
            if (pIndex == pLen - 1 || p.charAt(pIndex + 1) != '*') {
                // .是最后一个字符，或者下一个字符不是*
                isFound = backTracking(s, p, sIndex + 1, pIndex + 1);
            } else {
                // .*
                for (int i = sIndex; i <= sLen; i++) {
                    isFound = backTracking(s, p, i, pIndex + 2);
                    if (isFound) { // 找到就可以返回了
                        memo[key] = 1;
                        return true;
                    }
                }
            }
        } else {
            if (sChar != pChar) {
                if (pIndex == pLen - 1 || p.charAt(pIndex + 1) != '*') {
                    memo[key] = 0;
                    return false;
                }

                // pIndex下一个位置是*， 当前字符不一样，只能让*作用成0个当前pIndex所指的字符
                isFound = backTracking(s, p, sIndex, pIndex + 2);
            } else {
                if (pIndex == pLen - 1 || p.charAt(pIndex + 1) != '*') {
                    isFound = backTracking(s, p, sIndex + 1, pIndex + 1);
                } else {
                    // pIndex和sIndex的字符相等，且pIndex的下一个字符是*
                    int maxMatchCount = 1; // 看p的这个*最多可以匹配s的几个字符
                    for (int i = sIndex + 1; i < sLen; i++) {
                        if (s.charAt(i) != pChar) {
                            break;
                        }
                        maxMatchCount++;
                    }

                    for (int i = sIndex; i <= sIndex + maxMatchCount; i++) {
                        isFound = backTracking(s, p, i, pIndex + 2);
                        if (isFound) { //找到就可以返回了
                            memo[key] = 1;
                            return true;
                        }
                    }
                }
            }
        }

        memo[key] = isFound ? 1 : 0;
        return isFound;
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        memo = new int[(sLen + 1) * 100 + pLen + 1];
        pLeftSubStrCanEmptyMemo = new int[pLen + 1];
        Arrays.fill(memo, -1);
        Arrays.fill(pLeftSubStrCanEmptyMemo, -1);
        return backTracking(s, p, 0, 0);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem010().isMatch("aa", "a"));
        System.out.println(new Problem010().isMatch("aa", "a*"));
        System.out.println(new Problem010().isMatch("ab", ".*"));
        System.out.println(new Problem010().isMatch("aab", "c*a*b"));
        System.out.println(new Problem010().isMatch("mississippi", "mis*is*p*."));
        System.out.println(new Problem010().isMatch("aaa", "a*a"));
    }
    
}
