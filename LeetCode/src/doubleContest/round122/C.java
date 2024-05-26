package doubleContest.round122;

import java.util.Arrays;

public class C {

    public int minimumArrayLength(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return 1;
        }

        Arrays.sort(nums);
        // 求模最小的（除了0）
        if (nums[0] == 1) {
            // 查看1的个数
            int oneCount = 1;
            for (int i = 1; i < len; i++) {
                if (nums[i] != 1) {
                    break;
                }
                oneCount++;
            }
            return oneCount / 2 + (oneCount % 2);
        }

        // 最小值不是1，查看后面有没有存在非最小值倍数的
        int min = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] % min != 0) {
                return 1;
            }
        }
        int minCount = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != min) {
                break;
            }
            minCount++;
        }
        return minCount / 2 + (minCount % 2);
    }

}
