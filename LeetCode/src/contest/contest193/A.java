package contest.contest193;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/14
 */
public class A {

    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = nums[0];
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] + nums[i];
        }

        return ans;
    }

}
