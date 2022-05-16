package contest.contest284;

public class C {

    public int maximumTop(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return k % 2 == 1 ? -1 : nums[0];
        }

        if (k > len) {
            int max = 0;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }

        if (k == len) {
            // 只能执行k-1次删除，
            int max = 0;
            for (int i = 0; i < k - 1; i++) {
                max = Math.max(max, nums[i]);
            }
            return max;
        }

        // k < len
        int max = 0;
        for (int i = 0; i < k - 1; i++) {
            max = Math.max(max, nums[i]);
        }
        return Math.max(max, nums[k]);
    }

}
