package problem1001_1100;

public class Problem1060 {

    public int missingElement(int[] nums, int k) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            int diff = nums[i+1] - nums[i] - 1;
            if (k <= diff) {
                return nums[i] + k;
            }
            k -= diff;
        }

        return nums[len-1] + k;
    }

}
