package lcof;

public class Lcof042 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] preSumArr = new int[len];
        preSumArr[0] = nums[0];
        int preSumMin = Math.min(0, preSumArr[0]);
        int ansMax = nums[0];

        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i-1] + nums[i];
            ansMax = Math.max(ansMax, preSumArr[i] - preSumMin);
            preSumMin = Math.min(preSumMin, preSumArr[i]);
        }

        return ansMax;
    }

}
