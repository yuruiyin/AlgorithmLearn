package contest.contest349;

import java.util.Arrays;

public class A {

    public int findNonMinOrMax(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int num : nums) {
            if (num != min && num != max) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
