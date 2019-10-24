package problem501_600;

import java.util.Stack;

public class Problem503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return new int[0];
        }

        if (n == 1) {
            return new int[]{-1};
        }

        // 单调栈
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            stack.push(nums[i]);
        }

        int[] ansArr = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }

            ansArr[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i]);
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[] ansArr = new Problem503().nextGreaterElements(new int[]{1,2,1});
        
        for (int num : ansArr) {
            System.out.print(num + ",");
        }
        System.out.println();
    }

}
