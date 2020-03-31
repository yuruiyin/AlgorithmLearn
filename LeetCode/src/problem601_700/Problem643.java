package problem601_700;

/**
 * Problem643
 *
 * @author: yry
 * @date: 2020/3/30
 */
public class Problem643 {

    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        long ansMax = sum;
        for (int i = 1; i <= n - k; i++) {
            sum = sum - nums[i-1] + nums[i + k - 1];
            ansMax = Math.max(ansMax, sum);
        }

        return (double) ansMax / k;
    }

}
