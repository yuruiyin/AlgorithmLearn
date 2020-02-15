package lcof;

public class Lcof042_1 {

    public int maxSubArray(int[] nums) {
        int preMax = nums[0];
        int ansMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (preMax > 0) {
                preMax += nums[i];
            } else {
                preMax = nums[i];
            }
            ansMax = Math.max(ansMax, preMax);
        }

        return ansMax;
    }

}
