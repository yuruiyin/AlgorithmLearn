package problem201_300;

public class Problem220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        int len = nums.length;
        if (k >= len) {
            return true;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= i + k && j < len; j++) {
                if (Math.abs((long) nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }

        return false;
    }

}
