package contest.contest232;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/14
 */
public class D {

    public int maximumScore(int[] nums, int k) {
        int len = nums.length;
        int ansMax = 0;
        // 枚举最小值
        int l = k;
        int r = k;
        for (int i = nums[k]; i >= 1; i--) {
            while (l > 0 && nums[l - 1] >= i) {
                l--;
            }

            while (r < len - 1 && nums[r + 1] >= i) {
                r++;
            }

            ansMax = Math.max(ansMax, i * (r - l + 1));
        }

        return ansMax;
    }

}
