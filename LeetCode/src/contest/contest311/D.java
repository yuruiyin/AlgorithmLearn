package contest.contest311;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class D {

    static class StrHash {

        private static final long P = 805306457;
        private long[] hash;
        private long[] power;
        private char[] arr;

        private int mod;

        public StrHash(char[] arr, int mod) {
            this.arr = arr;
            this.mod = mod;
            int len = arr.length;
            hash = new long[len];
            power = new long[len];
            calcHashAndPower();
        }

        private void calcHashAndPower() {
            hash[0] = arr[0];
            power[0] = 1;
            for (int i = 1; i < arr.length; i++) {
                hash[i] = (hash[i-1] * P + arr[i]) % mod;
                power[i] = (power[i-1] * P) % mod;
            }
        }

        private long getSubStrHash(int l, int r) {
            if (l == 0) {
                return hash[r];
            }
            return ((hash[r] - power[r-l+1] * hash[l-1]) % mod + mod) % mod;
        }

    }

    public int[] sumPrefixScores(String[] words) {
        int len = words.length;
        int[] arr = new int[len];
        Map<Long, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char[] charArr = words[i].toCharArray();
            StrHash strHash1 = new StrHash(charArr, 1000000901);
            StrHash strHash2 = new StrHash(charArr, (int) (1e9 + 7));
            for (int j = 0; j < charArr.length; j++) {
                long hash1 = strHash1.getSubStrHash(0, j);
                long hash2 = strHash2.getSubStrHash(0, j);
                long key = hash2 * 1000000902 + hash1;
                countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            }
        }

        for (int i = 0; i < len; i++) {
            char[] charArr = words[i].toCharArray();
            StrHash strHash1 = new StrHash(charArr, 1000000901);
            StrHash strHash2 = new StrHash(charArr, (int) (1e9 + 7));
            for (int j = 0; j < charArr.length; j++) {
                long hash1 = strHash1.getSubStrHash(0, j);
                long hash2 = strHash2.getSubStrHash(0, j);
                long key = hash2 * 1000000902 + hash1;
                arr[i] += countMap.getOrDefault(key, 0);
            }
        }

        return arr;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        for (int i = (int) (1e9+899); ; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                break;
            }
        }
    }

}
