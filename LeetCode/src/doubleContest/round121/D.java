package doubleContest.round121;

public class D {

    /**
     * 求 <= max中满足条件的个数
     */
    private long calcCount(long max, int limit, String s) {
        long suffix = Long.parseLong(s);
        if (suffix > max) {
            return 0;
        }
        if (suffix == max) {
            return 1;
        }

        String maxStr = String.valueOf(max);
        int maxLen = maxStr.length();

        long ans = 1;
        long pre = 1;
        int curLen = s.length();
        while (curLen < maxLen - 1) {
            pre *= (limit + 1);
            ans += pre;
            curLen++;
        }

        // curLen == maxLen
        int highBit = maxStr.charAt(0) - '0';
        if (highBit > limit) {
            pre *= limit;
            ans += pre;
            return ans;
        }

        ans += pre * (highBit - 1);

        // 剩下的必须判断大小
        long left = 1;
        for (int i = 1; i < maxLen - s.length(); i++) {
            left *= Math.min(limit, maxStr.charAt(i) - '0') + 1;
        }

        ans += left;
        return ans;
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long max1 = finish;
        long max2 = start - 1;
        return calcCount(max1, limit, s) - calcCount(max2, limit, s);
    }

}
