package doubleContest.round075;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

    public long sumScores(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        if (len == 1) {
            return 1;
        }

        StrHash strHash = new StrHash(arr);
        long ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            // [i, len - 1]
            int l = 1;
            int r = len - i;
            int maxPreLen = -1;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (strHash.getSubStrHash(0, mid - 1) == strHash.getSubStrHash(i, i + mid - 1)) {
                    maxPreLen = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (maxPreLen != -1) {
                ans += maxPreLen;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "a".repeat(100000);
        System.out.println(new D().sumScores(str));
    }

}
