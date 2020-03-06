package problem401_500;

public class Problem459_1 {

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

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        StrHash strHash = new StrHash(s.toCharArray());

        for (int l = len / 2; l > 0; l--) {
            if (len % l != 0) {
                continue;
            }

            long curHash = strHash.getSubStrHash(0, l - 1);
            boolean isOk = true;
            for (int i = l; i <= len - l; i += l) {
                long tmpHash = strHash.getSubStrHash(i, i + l - 1);
                if (tmpHash != curHash) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                return true;
            }
        }

        return false;
    }

}
