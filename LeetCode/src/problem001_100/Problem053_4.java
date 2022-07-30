package problem001_100;

public class Problem053_4 {

    public int maxSubArray(int[] nums) {
        int preMin = Math.min(0, nums[0]);
        int ansMax = nums[0];
        int preSum = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            preSum += nums[i];
            int curMax = preSum - preMin;
            ansMax = Math.max(ansMax, curMax);
            preMin = Math.min(preMin, preSum);
        }
        return ansMax;
    }

}
