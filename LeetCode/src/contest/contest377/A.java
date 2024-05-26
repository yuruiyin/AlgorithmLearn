package contest.contest377;

import java.util.Arrays;

public class A {

    public int[] numberGame(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int[] ans = new int[len];
        int idx = 0;
        for (int i = 0; i < len; i += 2) {
            ans[idx++] = nums[i + 1];
            ans[idx++] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
