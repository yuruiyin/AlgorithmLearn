package problem901_1000;

import java.util.Arrays;

/**
 * Problem945_3
 *
 * @author: yry
 * @date: 2020/3/22
 */
public class Problem945_3 {

    private static final int MAX = 40005;

    public int minIncrementForUnique(int[] arr) {
        int[] countArr = new int[MAX];
        int max = 0;
        for (int num : arr) {
            countArr[num]++;
            max = Math.max(max, countArr[num]);
        }

        int ans = 0;
        for (int i = 0; i < max; i++) {
            if (countArr[i] > 1) {
                ans += countArr[i] - 1;
                countArr[i + 1] += countArr[i] - 1;
            }
        }

        int n = countArr[max];
        return ans + (n - 1) * n / 2;
    }

}
