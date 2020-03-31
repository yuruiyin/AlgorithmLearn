package contest.contest182;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/29
 */
public class D {

    private static final int MOD = (int) (1e9 + 7);

    private int diffWithAAA(String str) {
        int len = str.length();
        long ans = 0;
        for (int i = 0; i < len; i++) {
            ans *= 26;
            ans = (ans + str.charAt(i) - 'a') % MOD;
        }
        return (int) ((ans + 1) % MOD);
    }

    private int diffZZZZandAAA(int len) {
        long ans = 0;
        for (int i = 0; i < len; i++) {
            ans *= 26;
            ans = (ans + 'z' - 'a') % MOD;
        }
        return (int) ((ans + 1) % MOD);
    }

    private int[] memo;
    private int evilLen;
    private String evil;

    private boolean isEvilAllA() {
        for (char c : evil.toCharArray()) {
            if (c != 'a') {
                return false;
            }
        }

        return true;
    }

    // 从'aaa...' 开始
    private int getCount(String str, int end) {
        if (memo[end] != -1) {
            return memo[end];
        }

        int len = end + 1;
        long count = 0;

        // 拿evil字符串在str字符串上右移
        for (int i = 0; i <= len - evilLen; i++) {
            String midStr = str.substring(i, i + evilLen);
            int cmp = midStr.compareTo(evil);
            if (i == 0) {
                // cmp < 0 说明当前以evil开头的字符串太大，可忽略
                if (cmp == 0) {
                    int tmpCount = diffWithAAA(str.substring(evilLen, len));
                    count = (count + tmpCount) % MOD;
                } else if (cmp > 0) {
                    // cmp > 0, 说明当前子串大于evil,那么后面剩下的应该是用zzz... - aaa...
                    int tmpCount = diffZZZZandAAA(len - evilLen);
                    count = (count + tmpCount) % MOD;
                }
            } else {
                // evil在中间
                String leftStr = str.substring(0, i);
                String rightStr = str.substring(i + evilLen, len);
                long leftCount = diffWithAAA(leftStr);
                if (cmp < 0) {
                    if (leftCount == 1) {
                        // 说明太小
                        continue;
                    }

                    leftCount--;
                    leftCount = (leftCount - getCount(str, i - 1) + MOD) % MOD;
                    long tmpCount = (leftCount * diffZZZZandAAA(len - evilLen - i)) % MOD;
                    count = (count + tmpCount) % MOD;
                } else if (cmp == 0) {
                    if (leftCount == 1) {
                        // 前缀（左侧+evil区域）相等
                        if (isEvilAllA()) {
                            continue;
                        }
                        count = (count + diffWithAAA(rightStr)) % MOD;
                        continue;
                    }

                    leftCount--;
                    leftCount = (leftCount - getCount(str, i - 1) + MOD) % MOD;
                    long tmpCount = ((leftCount * diffZZZZandAAA(len - evilLen - i)) % MOD + (long) diffWithAAA(rightStr)) % MOD;
                    count = (count + tmpCount) % MOD;
                } else {
                    //cmp > 0
                    leftCount = (leftCount - getCount(str, i - 1) + MOD) % MOD;
                    long tmpCount = (leftCount * diffZZZZandAAA(len - evilLen - i)) % MOD;
                    count = (count + tmpCount) % MOD;
                }
            }
        }

        memo[end] = (int) count;
        return memo[end];
    }

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        if (s1.equals(s2)) {
            return s1.contains(evil) ? 0 : 1;
        }

        this.evil = evil;
        this.evilLen = evil.length();

        long totalCount = (diffWithAAA(s2) - diffWithAAA(s1) + MOD + 1) % MOD;
        memo = new int[n + 1];
        Arrays.fill(memo, - 1);
        long count1 = getCount(s1, s1.length() - 1);
        Arrays.fill(memo, - 1);
        long count2 = getCount(s2, s2.length() - 1);
        int offset = s1.contains(evil) ? 1 : 0;
        long evilCount = (count2 - count1 + offset + MOD) % MOD;
        return (int) ((totalCount - evilCount + MOD) % MOD);
    }
    
    public static void main(String[] args) {
//        System.out.println(new D().findGoodStrings(2, "aa", "da", "b"));
//        System.out.println(new D().findGoodStrings(8, "leetcode", "leetgoes", "leet"));
//        System.out.println(new D().findGoodStrings(2, "gx", "gz", "x"));
//        System.out.println(new D().findGoodStrings(4, "aaaa", "aabc", "b"));
        System.out.println(new D().findGoodStrings(24, "bqdkyblcurkzakgssmqlilwy", "uaklruspcoqrfleedknktbcu", "ziymrjsz"));
    }

}
