package problem1001_1100;

public class Problem1063_1 {

    public int validSubarrays(int[] nums) {
        // 其实就是求右边第一个比他小的元素的位置，然后求位置差即可
        int len = nums.length;
        int[] stack = new int[len]; // 放下标
        int top = -1;
        int ans = 0;

        for (int i = len - 1; i >= 0; i--) {
            while (top != -1 && nums[stack[top]] >= nums[i]) {
                top--;
            }

            if (top == -1) {
                ans += (len - i);
            } else {
                ans += stack[top] - i;
            }

            stack[++top] = i;
        }

        return ans;
    }

}
