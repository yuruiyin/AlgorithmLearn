package contest.contest368;

public class B {

    public int minimumSum(int[] nums) {
        int len = nums.length;
        int sum = Integer.MAX_VALUE;
        int[] leftMinArr = new int[len];
        int[] rightMinArr = new int[len];
        leftMinArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            leftMinArr[i] = Math.min(leftMinArr[i - 1], nums[i]);
        }
        rightMinArr[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMinArr[i] = Math.min(rightMinArr[i + 1], nums[i]);
        }

        for (int i = 1; i < len - 1; i++) {
            int leftMin = leftMinArr[i - 1];
            int rightMin = rightMinArr[i + 1];
            if (nums[i] > leftMin && nums[i] > rightMin) {
                sum = Math.min(sum, nums[i] + leftMin + rightMin);
            }
        }

        return sum == Integer.MAX_VALUE ? -1 : sum;
    }

}
