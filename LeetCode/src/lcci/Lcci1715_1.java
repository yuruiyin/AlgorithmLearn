package lcci;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 使用字符串hash
 *
 * @author: yry
 * @date: 2020/3/23
 */
public class Lcci1715_1 {

    static class StrHash {

        private static final long P = 805306457;
        private static final long MOD = (int) (1e9+7);
        private long[] hash;
        private long[] power;
        private char[] arr;

        public StrHash(char[] arr) {
            this.arr = arr;
            int len = arr.length;
            hash = new long[len];
            power = new long[len];
            calcHashAndPower();
        }

        private void calcHashAndPower() {
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

    }

    private Set<Long> set;
    private Boolean[] memo;
    private StrHash[] strHashes;

    private boolean dp(int from, int wordLen, int wordIdx) {
        if (from == wordLen) {
            return true;
        }

        if (memo[from] != null) {
            return memo[from];
        }

        for (int i = from; i < wordLen; i++) {
            if (set.contains(strHashes[wordIdx].getSubStrHash(from, i)) && dp(i + 1, wordLen, wordIdx)) {
                memo[from] = true;
                return true;
            }
        }

        memo[from] = false;
        return false;
    }

    public String longestWord(String[] words) {
        Arrays.sort(words, (o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length());
        set = new HashSet<>();
        strHashes = new StrHash[words.length];
        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                continue;
            }
            strHashes[i] = new StrHash(words[i].toCharArray());
            set.add(strHashes[i].getSubStrHash(0, words[i].length() - 1));
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) {
                continue;
            }

            memo = new Boolean[word.length()];
            long hash = strHashes[i].getSubStrHash(0, word.length() - 1);
            set.remove(hash);
            if (dp(0, word.length(), i)) {
                return word;
            }
            set.add(hash);
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Lcci1715_1().longestWord(new String[]{
                "qlmql","qlmqlmqqlqmqqlq","mqqlqmqqlqmqqlq","mqqlq","mqqlqlmlsmqq","qmlmmmmsm","lmlsmqq","slmsqq","mslqssl","mqqlqmqqlq"
        }));
    }

}
