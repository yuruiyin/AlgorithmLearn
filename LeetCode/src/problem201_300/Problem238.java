package problem201_300;

public class Problem238 {

    public int[] productExceptSelf(int[] nums) {
        // 乘积 = 当前数左边的乘积 * 当前数右边的乘积
        int len = nums.length;
        int[] ans = new int[len];
        int sum = 1;

        for (int i = 0; i < len; i++) {
            ans[i] = sum;
            sum *= nums[i];
        }

        sum = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] *= sum;
            sum *= nums[i];
        }

        return ans;
    }

}
