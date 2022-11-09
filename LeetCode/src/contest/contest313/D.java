package contest.contest313;

import java.util.Arrays;

public class D {

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

    private char[] arr;
    private int len;

    private int[] memo;

    private StrHash strHash;

    private int rec(int cur) {
        if (memo[cur] != -1) {
            return memo[cur];
        }

        int ansMax = 1;
        for (int i = (len + cur) / 2 - 1; i >= cur; i--) {
            if (strHash.getSubStrHash(cur, i) == strHash.getSubStrHash(i + 1, 2 * i - cur + 1)) {
//                ansMax = Math.max(ansMax, 1 + rec(i + 1));
                int res = 1 + rec(i + 1);
                if (res > ansMax) {
                    ansMax = res;
                }
            }
        }
        memo[cur] = ansMax;
        return ansMax;
    }

    public int deleteString(String s) {
        this.arr = s.toCharArray();
        this.len = arr.length;
        memo = new int[len];
        Arrays.fill(memo, -1);
        strHash = new StrHash(arr);
        return rec(0);
    }

    public static void main(String[] args) {
        System.out.println(new D().deleteString("a".repeat(4000)));
        System.out.println("a".repeat(4000));
    }

}
