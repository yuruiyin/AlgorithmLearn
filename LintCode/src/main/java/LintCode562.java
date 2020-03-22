import java.util.Arrays;

/**
 * LintCode562
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode562 {

    public int backPackIV(int[] nums, int target) {
        // write your code here
        int[] dp = new int[target + 1];
        dp[0] = 1;

        Arrays.sort(nums);

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length && nums[j] <= i; j++) {
                dp[i] += dp[i - nums[j]];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new LintCode562().backPackIV(new int[]{2,3 ,6 ,7}, 7));
    }

}
