package contest.contest445;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    private final Map<String, Integer> memo = new HashMap<>();

    private int countReal(BigInteger num, int base) {
        if (num.compareTo(BigInteger.ZERO) < 0) {
            return 0;
        }

        memo.clear();
        int[] digits = toBase(num, base);
        return rec(0, 0, true, true, digits, base);
    }

    private int[] toBase(BigInteger num, int base) {
        if (num.equals(BigInteger.ZERO)) {
            return new int[]{0};
        }

        int[] temp = new int[100];
        int len = 0;
        while (num.compareTo(BigInteger.ZERO) > 0) {
            temp[len++] = num.mod(BigInteger.valueOf(base)).intValue();
            num = num.divide(BigInteger.valueOf(base));
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = temp[len - i - 1];
        }
        return res;
    }

    private int rec(int pos, int prev, boolean tight, boolean leadZero, int[] digits, int base) {
        if (pos == digits.length) {
            return leadZero ? 0 : 1;
        }

        String key = pos + "," + prev + "," + tight + "," + leadZero;
        if (!tight && !leadZero && memo.containsKey(key)) {
            return memo.get(key);
        }

        int maxDigit = tight ? digits[pos] : base - 1;
        int total = 0;
        for (int d = 0; d <= maxDigit; d++) {
            if (!leadZero && d < prev) continue;
            boolean nextTight = tight && (d == maxDigit);
            boolean nextZero = leadZero && (d == 0);
            int nextPrev = nextZero ? 0 : d;
            total = (total + rec(pos + 1, nextPrev, nextTight, nextZero, digits, base)) % MOD;
        }

        if (!tight && !leadZero) {
            memo.put(key, total);
        }

        return total;
    }

    public int countNumbers(String l, String r, int b) {
        int resL = countReal(new BigInteger(l).subtract(BigInteger.ONE), b);
        int resR = countReal(new BigInteger(r), b);
        return (resR - resL + MOD) % MOD;
    }

}
