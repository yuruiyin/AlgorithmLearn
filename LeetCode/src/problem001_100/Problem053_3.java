package problem001_100;

public class Problem053_3 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ansMax = nums[0];
        int len = nums.length;
        int preMax = nums[0];
        for (int i = 1; i < len; i++) {
            preMax = preMax <= 0 ? nums[i] : preMax + nums[i];
            ansMax = Math.max(ansMax, preMax);
        }

        return ansMax;
    }

}
