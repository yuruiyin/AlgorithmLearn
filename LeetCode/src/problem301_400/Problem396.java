package problem301_400;

public class Problem396 {

    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            ansMax += i * nums[i];
            sum += nums[i];
        }
        int preValue = ansMax;
        for (int k = 1; k < len; k++) {
            preValue = preValue - len * nums[len - k] + sum;
            ansMax = Math.max(ansMax, preValue);
        }

        return ansMax;
    }

}
