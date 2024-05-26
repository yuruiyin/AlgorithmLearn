package contest.contest355;

public class B {

    public long maxArrayValue(int[] nums) {
        int len = nums.length;
        long[] arr = new long[len];
        for (int i = 0; i < len; i++) {
            arr[i] = nums[i];
        }
        long ans = 0;
        for (int i = len - 1; i >= 1; i--) {
            if (arr[i] >= arr[i - 1]) {
                arr[i - 1] += arr[i];
                arr[i] = 0;
            }
        }

        for (long num : arr) {
            ans = Math.max(ans, num);
        }
        return ans;
    }

}
