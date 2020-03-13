package problem501_600;

import java.util.HashMap;
import java.util.Map;

public class Problem535 {

    public class Codec {

        public class StrHash {

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

        private Map<Long, String> hashToStrMap;
        private StrHash strHash;

        Codec() {
            hashToStrMap = new HashMap<>();
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            strHash = new StrHash(longUrl.toCharArray());
            long hash = strHash.getSubStrHash(0, longUrl.length() - 1);
            hashToStrMap.put(hash, longUrl);
            return String.valueOf(hash);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return hashToStrMap.get(Long.parseLong(shortUrl));
        }
    }

}
