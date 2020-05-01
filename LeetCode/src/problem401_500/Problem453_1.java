package problem401_500;

/**
 * Problem453_1
 *
 * @author: yry
 * @date: 2020/4/15
 */
public class Problem453_1 {

    public int minMoves(int[] nums) {
        // n - 1个数都加1，比如是最小的数都加1，那么相当于最大的数减1, 最终都减到最小值即可
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }

        int ans = 0;
        for (int num : nums) {
            ans += num - min;
        }
        return ans;
    }


}
