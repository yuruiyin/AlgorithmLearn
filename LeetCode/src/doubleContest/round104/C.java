package doubleContest.round104;

import java.util.Arrays;

public class C {

    public long maximumOr(int[] nums, int k) {
        int maxLen = 32 + k;
        int[] bitCountArr = new int[maxLen];
        int highIdx = 0;
        for (int num : nums) {
            for (int i = 0; i < 32 && num > 0; i++) {
                int bit = num & 1;
                num >>= 1;
                if (bit == 1) {
                    highIdx = Math.max(highIdx, i);
                    bitCountArr[i]++;
                }
            }
        }

        long ansMax = 0;
        long min = 1L << highIdx;
        for (int num : nums) {
            if (num < min) {
                continue;
            }
            // 将num左移k位
            long oldNum = num;
            int[] tmpBitCountArr = Arrays.copyOf(bitCountArr, bitCountArr.length);
            for (int i = 0; i < 32 && num > 0; i++) {
                int bit = num & 1;
                num >>= 1;
                if (bit == 1) {
                    tmpBitCountArr[i]--;
                }
            }
            oldNum <<= k;
            for (int i = 0; i < maxLen && oldNum > 0; i++) {
                long bit = oldNum & 1;
                oldNum >>= 1;
                if (bit == 1) {
                    tmpBitCountArr[i]++;
                }
            }
            long value = 0;
            for (int i = 0; i < maxLen; i++) {
                if (tmpBitCountArr[i] > 0) {
                    value += (1L << i);
                }
            }
            ansMax = Math.max(ansMax, value);
        }
        return ansMax;
    }

}
