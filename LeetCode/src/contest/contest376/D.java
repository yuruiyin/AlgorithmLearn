package contest.contest376;

import java.util.Arrays;

public class D {

    public int maxFrequencyScore(int[] nums, long k) {
//        给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
//
//        你可以对数组执行 至多 k 次操作：
//
//        从数组中选择一个下标 i ，将 nums[i] 增加 或者 减少 1 。
//        最终数组的频率分数定义为数组中众数的 频率 。
//
//        请你返回你可以得到的 最大 频率分数。
//
//        众数指的是数组中出现次数最多的数。一个元素的频率指的是数组中这个元素的出现次数。
        int len = nums.length;
        Arrays.sort(nums);
        long[] preSumArr = new long[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }
        long[] sufSumArr = new long[len];
        sufSumArr[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sufSumArr[i] = sufSumArr[i + 1] + nums[i];
        }

        // todo
        return 0;

    }

}
