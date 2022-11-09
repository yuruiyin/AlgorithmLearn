package contest.contest102;

public class Problem906_2 {

    private boolean isPalindrome(long num) {
        return num == getReverse(num);
    }

    private long getReverse(long num) {
        long reverseNum = 0;
        while (num > 0) {
            reverseNum = reverseNum * 10 + num % 10;
            num /= 10;
        }
        return reverseNum;
    }

    private int recCount;

    /**
     * 获取数字的[反转数字, 数字长度pow]
     */
    private int[] getReverseNumAndPow(int num) {
        int reverseNum = 0;
        int pow10 = 1;
        while (num > 0) {
            reverseNum = reverseNum * 10 + num % 10;
            num /= 10;
            pow10 *= 10;
        }
        return new int[]{reverseNum, pow10};
    }

    private void rec(int i, int len, int value, long max) {
        if (i == len / 2) {
            int[] reverseNumAndPow = getReverseNumAndPow(value);
            if (len % 2 == 1) {
                // 奇数个
                int pow10 = reverseNumAndPow[1];
                int tmpValue = value * pow10 * 10 + reverseNumAndPow[0];
                for (int j = 0; j <= 9; j++) {
                    int num = tmpValue + j * pow10;
                    long square = (long) num * num;
                    if (square > max) {
                        break;
                    }
                    if (isPalindrome(square)) {
                        recCount++;
                    }
                }
            } else {
                int num = value * reverseNumAndPow[1] + reverseNumAndPow[0];
                long square = (long) num * num;
                if (square <= max && isPalindrome(square)) {
                    recCount++;
                }
            }
            return;
        }

        int start = i == 0 ? 1 : 0;
        int oldValue = value;
        for (int j = start; j <= 9; j++) {
            value = value * 10 + j;
            rec(i + 1, len, value, max);
            value = oldValue;
        }
    }

    /**
     * 求<=num以内的超级回文数
     */
    private int getCount(long num) {
        if (num == 0) {
            return 0;
        }

        int sqrt = (int) Math.sqrt(num);
        int count = String.valueOf(sqrt).length();
        int ansCount = 0;
        // 先单独处理1位的情况
        for (int i = 1; i <= 9; i++) {
            if (i > sqrt) {
                break;
            }
            if (i * i <= num && isPalindrome(i * i)) {
                ansCount++;
            }
        }

        for (int i = 2; i <= count; i++) {
            // 处理一半即可
            recCount = 0;
            rec(0, i, 0, num);
            ansCount += recCount;
        }
        return ansCount;
    }

    public int superpalindromesInRange(String left, String right) {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        return getCount(r) - getCount(l - 1);
    }

}
