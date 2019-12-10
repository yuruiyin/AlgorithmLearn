package problem1001_1100;

import java.util.Stack;

public class Problem1063 {

    public int validSubarrays(int[] nums) {
        // 其实就是求右边第一个比他小的元素的位置，然后位置差即可
        Stack<Integer> stack = new Stack<>(); // 放下标
        int len = nums.length;
        int ans = 0;

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans += (len - i);
            } else {
                ans += stack.peek() - i;
            }
            stack.push(i);
        }

        return ans;
    }

}

//  给定一个整数数组 A，返回满足下面条件的 非空、连续 子数组的数目：
//        子数组中，最左侧的元素不大于其他元素。
//
//        示例 1：
//
//        输入：[1,4,2,5,3]
//        输出：11
//        解释：有 11 个有效子数组，分别是：[1],[4],[2],[5],[3],[1,4],[2,5],[1,4,2],[2,5,3],[1,4,2,5],[1,4,2,5,3] 。
//        示例 2：
//
//        输入：[3,2,1]
//        输出：3
//        解释：有 3 个有效子数组，分别是：[3],[2],[1] 。
//        示例 3：
//
//        输入：[2,2,2]
//        输出：6
//        解释：有 6 个有效子数组，分别为是：[2],[2],[2],[2,2],[2,2],[2,2,2] 。
//         
//
//        提示：
//
//        1 <= A.length <= 50000
//        0 <= A[i] <= 100000

