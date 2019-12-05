package problem401_500;

import java.util.Arrays;

public class Problem416 {

    private int[] nums;
    private int len;
    private int[][] memo;

    private boolean backTrack(int from, int sum) {
        if (sum == 0) {
            return true;
        }

        if (from == len) {
            return false;
        }

        if (sum < 0 || sum < nums[from]) {
            return false;
        }

        if (memo[from][sum] != 0) {
            return memo[from][sum] == 1;
        }

        boolean chooseCurNumRes = backTrack(from + 1, sum - nums[from]); // 算上当前元素
        if (chooseCurNumRes) {
            memo[from][sum] = 1;
            return true;
        }

        boolean nonChooseCurNumRes = backTrack(from + 1, sum); // 不算当前元素
        memo[from][sum] = nonChooseCurNumRes ? 1 : -1;
        return nonChooseCurNumRes;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        this.nums = nums;
        len = nums.length;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            // 和为奇数的话 就不可能分成两个和相等的子数组
            return false;
        }

        // 将问题转化为寻找一个子数组，和为sum/2;
        int subSum = sum / 2;
        memo = new int[len][subSum+1];
        Arrays.sort(nums);
        return backTrack(0, subSum);
    }

}
