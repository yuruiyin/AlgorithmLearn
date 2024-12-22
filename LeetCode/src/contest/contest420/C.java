package contest.contest420;

import java.util.ArrayList;
import java.util.List;

public class C {

    private static Integer[] minFactorArr = new Integer[(int) (1e6 + 1)];

    private static Integer getMinFactor(int num) {
        if (minFactorArr[num] != null) {
            return minFactorArr[num];
        }
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                minFactorArr[num] = i;
                break;
            }
        }
        return minFactorArr[num];
    }

    public int minOperations(int[] nums) {
        int ans = 0;
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                Integer minFactor = getMinFactor(nums[i]);
                if (minFactor == null || minFactor > nums[i + 1]) {
                    return -1;
                }

                nums[i] = minFactor;
                ans++;
            }
        }

        return ans;
    }

}
