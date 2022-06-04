package problem401_500;

import java.util.Arrays;

public class Problem462 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        int[] preSumArr = new int[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }

        int l = 0;
        int r = len - 1;
        long ansMin = Long.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            long midValue = nums[mid];
            if (mid == len - 1) {
                long curCost = midValue * len - preSumArr[mid];
                long preCost = nums[mid] - nums[mid - 1] + (long)nums[mid - 1] * len - preSumArr[mid - 1];
                if (preCost >= curCost) {
                    return (int) curCost;
                }
                r = mid - 1;
            } else if (mid == 0) {
                long curCost = preSumArr[len - 1] - midValue * len;
                long nextCost = 2L * (nums[mid + 1] - nums[mid]) + preSumArr[len - 1] - midValue * len;
                if (curCost <= nextCost) {
                    return (int) curCost;
                }
                l = mid + 1;
            } else {
                // 考虑左侧和右侧
                long curCost = preSumArr[len - 1] - preSumArr[mid - 1] - (long) nums[mid] * (len - mid) ;
                long nextCost = preSumArr[len - 1] - preSumArr[mid] - (long) nums[mid] * (len - mid);
            }
        }

        // todo
        return -1;
    }

}
