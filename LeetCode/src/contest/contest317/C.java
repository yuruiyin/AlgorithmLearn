package contest.contest317;

public class C {

    private int getNumBitSum(long n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public long makeIntegerBeautiful(long n, int target) {
        // 发生在进位才有可能
        long bitSum = getNumBitSum(n);
        if (bitSum <= target) {
            return 0;
        }

        long oldN = n;
        long pow = 1;
        long right = 0;
        while (n > 0) {
            long mod = n % 10L;
            long x = (10 - mod) * pow + right;
            long newNum = oldN + x;
            long tmpBitSum = getNumBitSum(newNum);
            if (tmpBitSum <= target) {
                return x;
            }
            right = x;
            pow *= 10;
            n = newNum / pow;
        }
        return -1;
    }

}
