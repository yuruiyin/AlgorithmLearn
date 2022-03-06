package contest.contest280;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2022/2/13
 */
public class C {

    public long minimumRemoval(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        long[] preSumArr = new long[len];
        long sum = arr[0];
        preSumArr[0] = arr[0];
        for (int i = 1; i < len; i++) {
            sum += arr[i];
            preSumArr[i] = preSumArr[i - 1] + arr[i];
        }

        long ansMin = Long.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                continue;
            }

            long value = i == 0 ? sum - (long)len * arr[i] : preSumArr[i - 1] + (sum - preSumArr[i - 1] - (long)(len - i) * arr[i]);
            ansMin = Math.min(ansMin, value);
        }
        return ansMin;
    }

}
