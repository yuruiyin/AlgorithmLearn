import java.util.Arrays;

/**
 * LintCode562_1
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode562_1 {

    private int[] arr;
    private int len;
    private int[][] memo;

    private int dp(int from, int target) {
        if (target == 0) {
            return 1;
        }

        if (target < 0 || target < arr[from]) {
            return 0;
        }

        if (memo[from][target] != -1) {
            return memo[from][target];
        }

        int ans = 0;
        for (int i = from; i < len; i++) {
            ans += dp(i, target - arr[i]);
        }

        memo[from][target] = ans;
        return ans;
    }

    public int backPackIV(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return target == 0 ? 1:  0;
        }
        arr = nums;
        len = arr.length;
        Arrays.sort(arr);
        memo = new int[len][target + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, target);
    }

    public static void main(String[] args) {
        System.out.println(new LintCode562_1().backPackIV(new int[]{2,3,6,7}, 7));
    }

}
