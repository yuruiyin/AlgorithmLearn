package doubleContest.round77;

public class B {

    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int len = nums.length;
        long preSum = 0;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < len; i++) {
            preSum += nums[i];
            long leftAver = preSum / (i + 1);
            long rightAver = i == len - 1 ? 0 : (sum - preSum) / (len - i - 1);
            int value = (int) Math.abs(leftAver - rightAver);
            if (value < min) {
                min = value;
                minIdx = i;
            }
        }
        return minIdx;
    }

}
