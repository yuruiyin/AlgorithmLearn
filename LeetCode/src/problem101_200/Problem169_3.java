package problem101_200;

public class Problem169_3 {

    private int countInRange(int[] nums, int left, int right, int target) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (target == nums[i]) {
                ans++;
            }
        }

        return ans;
    }

    private int divideAndConquer(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) >>> 1;
        int leftMajority = divideAndConquer(nums, left, mid);
        int rightMajority = divideAndConquer(nums, mid + 1, right);

        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        int leftCount = countInRange(nums, left, right, leftMajority);
        int rightCount = countInRange(nums, left, right, rightMajority);

        return leftCount > rightCount ? leftMajority : rightMajority;

    }

    // 分治
    public int majorityElement(int[] nums) {
        int len = nums.length;
        return divideAndConquer(nums, 0, len - 1);
    }

}
