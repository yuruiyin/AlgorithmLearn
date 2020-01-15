package problem901_1000;

import java.util.Arrays;

public class Problem945_1 {

    public int minIncrementForUnique(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        }

        Arrays.sort(arr);
        int step = 0;
        int ans = 0;
        for (int num : arr) {
            if (num > step) {
                step = num + 1;
            } else {
                ans += step - num;
                step = step + 1;
            }
        }

        return ans;
    }

}
