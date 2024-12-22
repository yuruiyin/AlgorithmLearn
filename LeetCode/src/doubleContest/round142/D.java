package doubleContest.round142;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    static class CombinationInv {

        private long mod;
        private long[] frac;
        private long[] inv;

        public CombinationInv(long mod, int MAXN) {
            this.mod = mod;
            frac = new long[MAXN + 10];
            inv = new long[MAXN + 10];
            frac[0] = inv[0] = 1;
            init(MAXN);
        }

        private void init(int m) {
            for (int i = 1; i <= m; i++) {
                frac[i] = frac[i - 1] * i % mod;
                inv[i] = pow(frac[i], mod - 2);
            }
        }

        // 快速pow 二分
        private long pow(long x, long n) {
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

        public long c(int n, int m) {
            if (m < 0 || n < m) {
                return 0;
            }

            if (m > n - m) {
                m = n - m;
            }

            return frac[n] * inv[m] % mod * inv[n - m] % mod;
        }

    }

    public int possibleStringCount(String word, int k) {
        char[] arr = word.toCharArray();
        int len = arr.length;

        if (k == len) {
            return 1;
        }

        List<Integer> countList = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                countList.add(count);
                count = 1;
            }
        }

        countList.add(count);

        int sum = 0;
        for (int count1 : countList) {
            if (count1 > 1) {
                sum += count1 - 1;
            }
        }

        int from = countList.size();
        int to = k - 1;

        int ans = 1;
        for (int tmpCount : countList) {
            ans = (ans * tmpCount) % MOD;
        }

        CombinationInv combinationInv = new CombinationInv(MOD, sum);
        for (int i = from; i <= to; i++) {
            int removeCount = len - i;
            ans = (int) ((ans + MOD - combinationInv.c(sum, removeCount) % MOD) % MOD);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().possibleStringCount("kkkkk", 4));
    }

}
