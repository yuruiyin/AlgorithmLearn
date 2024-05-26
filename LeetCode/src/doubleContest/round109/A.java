package doubleContest.round109;

import java.util.Arrays;

public class A {

    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }
        return nums[n] == n;
    }

    public static void main(String[] args) {
        System.out.println("hello ");
    }

}
