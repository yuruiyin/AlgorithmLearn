package doubleContest.round17;

import java.util.HashSet;
import java.util.Set;

public class Problem1316 {

    private static final long P = 805306457;
    private static final long MOD = (int) (1e9+7);
    private long[] hash;
    private long[] power;

    private void calcHashAndPower(char[] arr) {
        hash[0] = arr[0];
        power[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            hash[i] = (hash[i-1] * P + arr[i]) % MOD;
            power[i] = (power[i-1] * P) % MOD;
        }
    }

    private long getSubStrHash(int l, int r) {
        if (l == 0) {
            return hash[r];
        }
        return ((hash[r] - power[r-l+1] * hash[l-1]) % MOD + MOD) % MOD;
    }

    public int distinctEchoSubstrings(String text) {
        Set<Long> set = new HashSet<>();
        char[] arr = text.toCharArray();
        int len = arr.length;
        hash = new long[len];
        power = new long[len];

        calcHashAndPower(arr);

        for (int i = 0; i < len - 1; i++) {
            int count = 1;
            while (i + 2 * count - 1 < len) {
                long hashLeft = getSubStrHash(i, i + count-1);
                long hashRight = getSubStrHash(i + count, i + 2 * count-1);
                if (hashLeft == hashRight) {
                    set.add(hashLeft);
                }

                count++;
            }
        }

        return set.size();
    }
    public static String getStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2000; i++) {
            sb.append('a');
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Problem1316().distinctEchoSubstrings(getStr()));
//        System.out.println(new Problem04().distinctEchoSubstrings("aaaaaaaaaa"));
        long end = System.currentTimeMillis();
        
        System.out.println("耗时：" + (end - start) + "ms");
    }

}

//    给你一个字符串 text ，请你返回满足下述条件的 不同 非空子字符串的数目：这些子字符串可以写成某个字符串与其自身的串联。
//
//
//
//        示例 1：
//
//        输入：text = "abcabcabc"
//        输出：3
//        解释：3 个子字符串分别为 "abcabc" ， "bcabca" 和 "cabcab" 。
//        示例 2：
//
//        输入：text = "leetcodeleetcode"
//        输出：2
//        解释：2 个子字符串为 "ee" 和 "leetcodeleetcode" 。
//
//
//        提示：
//
//        1 <= text.length <= 2000
//        text 只包含小写英文字母。
