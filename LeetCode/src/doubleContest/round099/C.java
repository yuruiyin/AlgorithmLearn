package doubleContest.round099;

import java.util.Arrays;
import java.util.Comparator;

public class C {

    private static final int MOD = (int) (1e9 + 7);

    // 快速幂
    public int pow(long x, long n, int mod) {
        long res = 1;
        x %= mod;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x % mod;
            }

            x = x * x % mod;
            n >>>= 1;
        }
        return (int) res % mod;
    }

    public int countWays(int[][] ranges) {
        int len = ranges.length;
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int preEnd = -1;
        int count = 0;
        for (int[] range : ranges) {
            int start = range[0];
            int end = range[1];
            if (start > preEnd) {
                count++;
            }
            preEnd = Math.max(preEnd, end);
        }

        return pow(2, count, MOD);
    }

}
