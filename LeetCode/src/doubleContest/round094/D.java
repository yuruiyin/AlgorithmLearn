package doubleContest.round094;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    // 快速pow 二分
    private long pow(long x, long n, long mod) {
        long res = 1;
        x %= mod;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % mod;
            }

            x = (x * x) % mod;
            n >>= 1;
        }
        return res % mod;
    }

    public int div(long a, long b, int mod) {
        return (int) (a * pow(b, mod - 2, mod) % mod);
    }

    public int countAnagrams(String s) {
        String[] arr = s.split(" ");
        long ans = 1;
        for (String str : arr) {
            Map<Character, Integer> countMap = new HashMap<>();
            for (char c : str.toCharArray()) {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }
            int n = str.length();

            // 求n!
            long value = 1;
            for (int i = 2; i <= n; i++) {
                value = (value * i) % MOD;
            }

            for (Character c : countMap.keySet()) {
                int count = countMap.get(c);
                long b = 1;
                for (int i = 2; i <= count; i++) {
                    b = (b * i) % MOD;
                }
                value = div(value, b, MOD);
            }

            ans = (ans * value) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().countAnagrams("aba bbb ccc"));
    }

}
