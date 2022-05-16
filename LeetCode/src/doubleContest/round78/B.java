package doubleContest.round78;

public class B {

    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long preSum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            preSum += nums[i];
            if (preSum >= sum - preSum) {
                ans++;
            }
        }
        return ans;
    }

}
