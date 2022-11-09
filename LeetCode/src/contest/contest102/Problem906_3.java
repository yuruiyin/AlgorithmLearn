package contest.contest102;

import java.util.HashSet;
import java.util.Set;

public class Problem906_3 {


    private static final Set<Integer> set = new HashSet<>();

    private boolean isPalindrome(long num) {
        long right = 0;
        while (num > right) {
            right = right * 10 + num % 10;
            num /= 10;
        }
        return num == right || num == right / 10;
    }

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

    private void rec(int i, int value) {
        if (i == 4) {
            int[] reverseNumAndPow = getReverseNumAndPow(value);
            // 中间加一个数的情况
            int pow10 = reverseNumAndPow[1];
            int tmpValue = value * pow10 * 10 + reverseNumAndPow[0];
            for (int j = 0; j <= 9; j++) {
                int num = tmpValue + j * pow10;
                long square = (long) num * num;
                if (isPalindrome(square)) {
                    set.add(num);
                }
            }

            // 中间不加一个数的情况
            int num = value * reverseNumAndPow[1] + reverseNumAndPow[0];
            long square = (long) num * num;
            if (isPalindrome(square)) {
                set.add(num);
            }
            return;
        }

        int oldValue = value;
        for (int j = 0; j <= 9; j++) {
            value = value * 10 + j;
            rec(i + 1, value);
            value = oldValue;
        }
    }

    public int superpalindromesInRange(String left, String right) {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);

        if (set.isEmpty()) {
            rec(0, 0);
        }
        int rCount = 0;
        int lCount = 0;
        for (long num : set) {
            if (num * num <= r) {
                rCount++;
            }
            if (num * num < l) {
                lCount++;
            }
        }

        return rCount - lCount;
    }

}
