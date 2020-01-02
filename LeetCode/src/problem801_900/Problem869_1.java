package problem801_900;

import java.util.Arrays;

public class Problem869_1 {

    // 思路：每位数字计数，看是否与2的幂数字计数相等，而Int中是2的幂的数也就是32个。
    public boolean reorderedPowerOf2(int n) {
        int[] countArr = count(n);
        for (int i = 0; i < 32; i++) {
            if (Arrays.equals(countArr, count(1 << i))) {
                return true;
            }
        }

        return false;
    }

    private int[] count(int n) {
        int[] countArr = new int[10];
        while (n > 0) {
            countArr[n % 10]++;
            n /= 10;
        }
        return countArr;
    }

}
