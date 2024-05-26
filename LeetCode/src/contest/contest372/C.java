package contest.contest372;

public class C {

    private static final int MOD = (int) (1e9 + 7);

    public int maximumXorProduct(long a, long b, int n) {
        char[] arr1 = Long.toBinaryString(a).toCharArray();
        char[] arr2 = Long.toBinaryString(b).toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        if (len1 > len2) {
            int zeroCount = len1 - len2;
            arr2 = ("0".repeat(zeroCount) + Long.toBinaryString(b)).toCharArray();
        } else if (len1 < len2) {
            int zeroCount = len2 - len1;
            arr1 = ("0".repeat(zeroCount) + Long.toBinaryString(a)).toCharArray();
        }

        int len = arr1.length;
        long x = 0;
        int fromIdx = 0;
        if (len < n) {
            int count = n - len;
            for (int i = 0; i < count; i++) {
                x += (1L << (n - i - 1));
            }
        } else if (len > n) {
            fromIdx = len - n;
        }

        long left = (1L << Math.min(n, len)) - 1;
        long res1 = 0;
        long res2 = 0;
        for (int i = fromIdx; i < len; i++) {
            long num = 1L << (len - i - 1);
            if (arr1[i] == '0' && arr2[i] == '0') {
                // 看看是否可以选1
                if (left >= num) {
                    x += num;
                    left -= num;
                    res1 += num;
                    res2 += num;
                }
            } else if (arr1[i] == '0' && arr2[i] == '1') {
                if (res1 >= res2) {
                    res2 += num;
                } else {
                    // 看是否可以选1
                    if (left >= num) {
                        x += num;
                        left -= num;
                        res1 += num;
                    } else {
                        res2 += num;
                    }
                }
            } else if (arr1[i] == '1' && arr2[i] == '0') {
                if (res2 >= res1) {
                    res1 += num;
                } else {
                    // 看是否可以选1
                    if (left >= num) {
                        x += num;
                        left -= num;
                        res2 += num;
                    } else {
                        res1 += num;
                    }
                }
            } else {
                res1 += num;
                res2 += num;
            }
        }

        return (int) (((a ^ x) % MOD) * ((b ^ x) % MOD));
    }

}
