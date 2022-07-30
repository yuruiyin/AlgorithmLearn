package problem301_400;

public class Problem396_1 {

    public int maxRotateFunction(int[] nums) {
        final int n = nums.length;
        int res = 0, last = 0, sum = 0;
        for (int i = 0; i < n; ++i) {
            res += i * nums[i];
            sum += nums[i];
        }
        last = res;

        for (int i = n - 1; i > 0; --i) {
            last += (sum - n * nums[i]);
            if (res < last) {
                res = last;
            }
        }

        return res;
    }

}
